plugins {
    id("chop-library-plugin")
}

dependencies {

    implementation(project(":core:base"))
    implementation(project(":core:uikit"))
    implementation(project(":core:repository"))
    implementation(project(":core:navigation"))


    koinDG()
    rxDG()
    coroutinesDG()
    retrofitAndGsonDG()
    navigationDG()
    chuckDG()
    navigationDG()
    androidXViewDG()

    // Logger
    implementation(Libraries.logger)

}