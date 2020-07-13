package com.bugsnag.android.gradle

import com.android.build.gradle.api.ApkVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.api.JavaCompileOptions
import com.android.build.gradle.api.SourceKind
import com.android.build.gradle.tasks.AidlCompile
import com.android.build.gradle.tasks.ExternalNativeBuildTask
import com.android.build.gradle.tasks.GenerateBuildConfig
import com.android.build.gradle.tasks.MergeResources
import com.android.build.gradle.tasks.MergeSourceSetFolders
import com.android.build.gradle.tasks.PackageAndroidArtifact
import com.android.build.gradle.tasks.RenderscriptCompile
import com.android.builder.model.BuildType
import com.android.builder.model.ProductFlavor
import com.android.builder.model.SigningConfig
import com.android.builder.model.SourceProvider
import org.gradle.api.DefaultTask
import org.gradle.api.DomainObjectCollection
import org.gradle.api.Task
import org.gradle.api.artifacts.ArtifactCollection
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Provider
import org.gradle.api.resources.TextResource
import org.gradle.api.tasks.AbstractCopyTask
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.compile.JavaCompile

@SuppressWarnings(["GetterMethodCouldBeProperty", "UnnecessaryReturnKeyword",
    "ReturnsNullInsteadOfEmptyCollection", "MethodCount", "BuilderMethodWithSideEffects",])
class FakeVariantImpl implements ApkVariant {

    private final String name

    FakeVariantImpl(String name) {
        this.name = name
    }

    @Override
    String getName() {
        return name
    }

    @Override
    String getDescription() {
        return null
    }

    @Override
    String getDirName() {
        return null
    }

    @Override
    String getBaseName() {
        return null
    }

    @Override
    String getFlavorName() {
        return null
    }

    @Override
    DomainObjectCollection<BaseVariantOutput> getOutputs() {
        return null
    }

    @Override
    BuildType getBuildType() {
        return null
    }

    @Override
    ProductFlavor getMergedFlavor() {
        return null
    }

    @Override
    JavaCompileOptions getJavaCompileOptions() {
        return null
    }

    @Override
    List<ProductFlavor> getProductFlavors() {
        return null
    }

    @Override
    List<SourceProvider> getSourceSets() {
        return null
    }

    @Override
    List<ConfigurableFileTree> getSourceFolders(SourceKind sourceKind) {
        return null
    }

    @Override
    Configuration getCompileConfiguration() {
        return null
    }

    @Override
    Configuration getAnnotationProcessorConfiguration() {
        return null
    }

    @Override
    Configuration getRuntimeConfiguration() {
        return null
    }

    @Override
    String getApplicationId() {
        return null
    }

    @Override
    Task getPreBuild() {
        return null
    }

    @Override
    Task getCheckManifest() {
        return null
    }

    @Override
    AidlCompile getAidlCompile() {
        return null
    }

    @Override
    RenderscriptCompile getRenderscriptCompile() {
        return null
    }

    @Override
    MergeResources getMergeResources() {
        return null
    }

    @Override
    MergeSourceSetFolders getMergeAssets() {
        return null
    }

    @Override
    GenerateBuildConfig getGenerateBuildConfig() {
        return null
    }

    @Override
    JavaCompile getJavaCompile() throws IllegalStateException {
        return null
    }

    @Override
    Task getJavaCompiler() {
        return null
    }

    @Override
    FileCollection getCompileClasspath(Object o) {
        return null
    }

    @Override
    ArtifactCollection getCompileClasspathArtifacts(Object o) {
        return null
    }

    @Override
    Collection<ExternalNativeBuildTask> getExternalNativeBuildTasks() {
        return null
    }

    @Override
    Task getObfuscation() {
        return null
    }

    @Override
    File getMappingFile() {
        return null
    }

    @Override
    AbstractCopyTask getProcessJavaResources() {
        return null
    }

    @Override
    Task getAssemble() {
        return null
    }

    @Override
    void addJavaSourceFoldersToModel(File... files) {

    }

    @Override
    void addJavaSourceFoldersToModel(Collection<File> collection) {

    }

    @Override
    void registerJavaGeneratingTask(Task task, File... files) {

    }

    @Override
    void registerJavaGeneratingTask(Task task, Collection<File> collection) {

    }

    @Override
    void registerExternalAptJavaOutput(ConfigurableFileTree configurableFileTree) {

    }

    @Override
    void registerGeneratedResFolders(FileCollection fileCollection) {

    }

    @Override
    void registerResGeneratingTask(Task task, File... files) {

    }

    @Override
    void registerResGeneratingTask(Task task, Collection<File> collection) {

    }

    @Override
    Object registerPreJavacGeneratedBytecode(FileCollection fileCollection) {
        return null
    }

    @Override
    Object registerGeneratedBytecode(FileCollection fileCollection) {
        return null
    }

    @Override
    void registerPostJavacGeneratedBytecode(FileCollection fileCollection) {

    }

    @Override
    void buildConfigField(String s, String s1, String s2) {

    }

    @Override
    void resValue(String s, String s1, String s2) {

    }

    @Override
    void missingDimensionStrategy(String s, String s1) {

    }

    @Override
    void missingDimensionStrategy(String s, String... strings) {

    }

    @Override
    void missingDimensionStrategy(String s, List<String> list) {

    }

    @Override
    void setOutputsAreSigned(boolean b) {

    }

    @Override
    boolean getOutputsAreSigned() {
        return false
    }

    @Override
    TextResource getApplicationIdTextResource() {
        return null
    }

    @Override
    TaskProvider<Task> getPreBuildProvider() {
        return null
    }

    @Override
    TaskProvider<Task> getCheckManifestProvider() {
        return null
    }

    @Override
    TaskProvider<AidlCompile> getAidlCompileProvider() {
        return null
    }

    @Override
    TaskProvider<RenderscriptCompile> getRenderscriptCompileProvider() {
        return null
    }

    @Override
    TaskProvider<MergeResources> getMergeResourcesProvider() {
        return null
    }

    @Override
    TaskProvider<MergeSourceSetFolders> getMergeAssetsProvider() {
        return null
    }

    @Override
    TaskProvider<GenerateBuildConfig> getGenerateBuildConfigProvider() {
        return null
    }

    @Override
    TaskProvider<JavaCompile> getJavaCompileProvider() {
        return null
    }

    @Override
    Collection<TaskProvider<ExternalNativeBuildTask>> getExternalNativeBuildProviders() {
        return null
    }

    @Override
    TaskProvider<AbstractCopyTask> getProcessJavaResourcesProvider() {
        return null
    }

    @Override
    TaskProvider<Task> getAssembleProvider() {
        return null
    }

    @Override
    FileCollection getAllRawAndroidResources() {
        return null
    }

    @Override
    void register(Task task) {

    }

    @Override
    Provider<FileCollection> getMappingFileProvider() {
        return null
    }

    @Override
    Object getDex() {
        return null
    }

    @Override
    PackageAndroidArtifact getPackageApplication() {
        return null
    }

    @Override
    TaskProvider<PackageAndroidArtifact> getPackageApplicationProvider() {
        return null
    }

    @Override
    SigningConfig getSigningConfig() {
        return null
    }

    @Override
    boolean isSigningReady() {
        return false
    }

    @Override
    Set<String> getCompatibleScreens() {
        return null
    }

    @Override
    DefaultTask getInstall() {
        return null
    }

    @Override
    TaskProvider<Task> getInstallProvider() {
        return null
    }

    @Override
    DefaultTask getUninstall() {
        return null
    }

    @Override
    TaskProvider<Task> getUninstallProvider() {
        return null
    }

    @Override
    int getVersionCode() {
        return 0
    }

    @Override
    String getVersionName() {
        return null
    }
}
