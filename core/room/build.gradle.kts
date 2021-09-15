plugins {
    id("chop-library-plugin")
}

dependencies {

    // Modules
    implementation(project(":core:base"))

    koinDG()
    coroutinesDG()
    retrofitAndGsonDG()
    chuckDG()
    roomDG()

}