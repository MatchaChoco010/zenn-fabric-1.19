import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val archivesName = "example_mod"
group = "net.orito-itsuki"
version = "0.1.0"

plugins {
    kotlin("jvm") version libs.versions.kotlin
    id("fabric-loom") version libs.versions.fabric.loom
}

dependencies {
    versionCatalogs {
        minecraft(libs.minecraft)
        mappings(libs.yarn)
        modImplementation(libs.fabric)
        modImplementation(libs.fabric.loader)
        modImplementation(libs.fabric.kotlin)
    }
}

tasks {
    val javaVersion = JavaVersion.VERSION_17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }
    withType<KotlinCompile> {
        kotlinOptions { jvmTarget = javaVersion.toString() }
    }
    jar { from("LICENSE") { rename { "${it}_${archivesName}" } } }
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }
    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}
