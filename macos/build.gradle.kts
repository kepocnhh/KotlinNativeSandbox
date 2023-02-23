repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    macosArm64 {
        binaries.executable()
    }
    sourceSets {
        "main".also { sourceSet ->
            val capitalized = sourceSet.capitalize()
            getByName("common$capitalized") {
                dependencies {
                    implementation(project(":common"))
                }
            }
            getByName("macosArm64$capitalized") {
                kotlin.srcDirs("src/macos/arm64/$sourceSet/kotlin")
            }
        }
    }
}
