rootProject.name = "Example Mod Kotlin"
pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") { name = "Fabric" }
        mavenLocal()
        gradlePluginPortal()
    }
}
include("example_mod")
