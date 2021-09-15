plugins {
    id("chop-library-plugin")
}

dependencies {

    // Modules
    implementation(project(":core:base"))
    implementation(project(":core:uikit"))
    implementation(project(":core:repository"))
    implementation(project(":core:navigation"))
    implementation(project(":core:room"))

    implementation(project(":friends"))

    baseModuleDG()

}