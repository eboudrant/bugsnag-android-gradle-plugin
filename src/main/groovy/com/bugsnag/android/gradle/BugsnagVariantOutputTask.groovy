package com.bugsnag.android.gradle

import com.android.build.FilterData
import com.android.build.VariantOutput
import com.android.build.gradle.api.BaseVariant
import com.android.build.gradle.api.BaseVariantOutput
import groovy.xml.Namespace
import org.gradle.api.DefaultTask

class BugsnagVariantOutputTask extends DefaultTask {

    private static final String SPLIT_UNIVERSAL = "universal"

    BaseVariantOutput variantOutput
    BaseVariant variant


    // Read from the manifest file
    String apiKey
    String versionCode
    String buildUUID
    String versionName

    /**
     * Gets the manifest for a given Variant Output, accounting for any APK splits.
     *
     * Currently supported split types include Density, and ABI. There is also a Language split,
     * but it appears to be broken (see issuetracker)
     *
     * @param output the variant output
     * @return the manifest path
     *
     * See: https://developer.android.com/studio/build/configure-apk-splits.html#build-apks-filename
     * https://issuetracker.google.com/issues/37085185
     */
    File getManifestPath() {
        File directory = variantOutput.processManifest.manifestOutputDirectory
        Collection<FilterData> filters = variantOutput.getFilters()

        project.logger.info("Filters: ${filters}")
        project.logger.info("OutputType: ${variantOutput.getOutputType()}")

        if (filters.isEmpty() && VariantOutput.OutputType.FULL_SPLIT.toString() == variantOutput.outputType) {
            directory = new File(directory, "universal") // universal apk is in different dir
        } else { // apk split
            String abi = null
            String density = null

            for (FilterData filterData : filters) {
                if (VariantOutput.FilterType.ABI.toString() == filterData.filterType) {
                    abi = filterData.identifier
                } else if (VariantOutput.FilterType.DENSITY.toString() == filterData.filterType) {
                    density = filterData.identifier
                }
            }
            directory = findManifestDirForSplit(density, abi, directory)
        }
        def file = new File(directory, "AndroidManifest.xml")

        if (!file.exists()) {
            project.logger.error("Failed to find manifest at ${file}")
        } else {
            project.logger.info("Found manifest at ${file}")
        }
        file
    }

    private static File findManifestDirForSplit(String density, String abi, File manifestDir) {
        if (abi != null && density != null) { // abi comes first, then density
            String subdir = abi + File.separator + density
            new File(manifestDir, subdir)
        } else if (abi != null) {
            new File(manifestDir, abi)
        } else if (density != null) {
            new File(manifestDir, density)
        } else {
            manifestDir
        }
    }


    // Read the API key and Build ID etc..
    void readManifestFile() {
        // Parse the AndroidManifest.xml
        Namespace ns = new Namespace("http://schemas.android.com/apk/res/android", "android")
        File manifestPath = getManifestPath()

        if (!manifestPath.exists()) {
            return
        }
        project.logger.debug("Reading manifest at: ${manifestPath}")

        Node xml = new XmlParser().parse(manifestPath)
        def metaDataTags = xml.application['meta-data']

        // Get the Bugsnag API key
        apiKey = getApiKey(metaDataTags, ns)
        if (!apiKey) {
            project.logger.warn("Could not find apiKey in '$BugsnagPlugin.API_KEY_TAG' <meta-data> tag in your AndroidManifest.xml or in your gradle config")
        }

        // Get the build version
        versionCode = getVersionCode(xml, ns)
        if (versionCode == null) {
            project.logger.warn("Could not find 'android:versionCode' value in your AndroidManifest.xml")
            return
        }

        // Uniquely identify the build so that we can identify the proguard file.
        buildUUID = getManifestMetaData(metaDataTags, ns, BugsnagPlugin.BUILD_UUID_TAG)

        // Get the version name
        versionName = getVersionName(xml, ns)
    }

    String getApiKey(metaDataTags, Namespace ns) {
        String apiKey

        if (project.bugsnag.apiKey != null) {
            apiKey = project.bugsnag.apiKey
        } else {
            apiKey = getManifestMetaData(metaDataTags, ns, BugsnagPlugin.API_KEY_TAG)
        }
        return apiKey
    }


    private String getManifestMetaData(metaDataTags, Namespace ns, String key) {
        String value = null

        def tags = metaDataTags.findAll {
            (it.attributes()[ns.name] == key)
        }
        if (tags.isEmpty()) {
            project.logger.warn("Could not find '$key' <meta-data> tag in your AndroidManifest.xml")
        } else {
            value = tags[0].attributes()[ns.value]
        }
        return value
    }

    String getVersionName(Node xml, Namespace ns) {
        xml.attributes()[ns.versionName]
    }

    String getVersionCode(Node xml, Namespace ns) {
        xml.attributes()[ns.versionCode]
    }

}
