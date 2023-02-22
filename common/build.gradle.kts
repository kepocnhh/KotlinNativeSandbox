repositories.mavenCentral()

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    macosArm64()
    jvm()
    sourceSets {
        "main".also { sourceSet ->
            val capitalized = sourceSet.capitalize()
            getByName("common$capitalized") {
                kotlin.srcDirs("src/common/$sourceSet/kotlin")
            }
            getByName("macosArm64$capitalized") {
                kotlin.srcDirs("src/macos/arm64/$sourceSet/kotlin")
            }
            getByName("jvm$capitalized") {
                kotlin.srcDirs("src/jvm/$sourceSet/kotlin")
            }
        }
    }
}
