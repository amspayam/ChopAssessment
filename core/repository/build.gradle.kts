plugins {
    id("chop-library-plugin")
}

dependencies {

    // Modules
    implementation(project(":core:base"))
    implementation(project(":core:room"))

    koinDG()
    rxDG()
    apolloDG()
    coroutinesDG()
    retrofitAndGsonDG()
    chuckDG()
    roomDG()

}