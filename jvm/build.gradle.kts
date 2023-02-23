repositories.mavenCentral()

plugins {
//    id("org.gradle.application")
    id("org.gradle.java")
    id("org.jetbrains.kotlin.multiplatform")
}

//application {
//    mainClass.set("AppKt")
//}

kotlin {
    jvm {
        withJava()
//        tasks.getByName<JavaCompile>("compileJava") {
//            targetCompatibility = Version.jvmTarget
//        }
//        tasks.getByName<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlinJvm") {
//            kotlinOptions.jvmTarget = Version.jvmTarget
//        }
//        val compilation = compilations.getByName("main")
//        val runTask = task<JavaExec>("jvmMainRun") {
//            mainClass.set("AppKt")
////            classpath(compilation.output.classesDirs, compilation.compileDependencyFiles)
//            classpath(compilation.output.classesDirs, configurations.getByName("runtimeClasspath"))
//        }
//        task<Jar>("jvmMainJar") {
////            manifest.attributes["Main-Class"] = "AppKt"
//            manifest.attributes["Main-Class"] = runTask.mainClass.get()
//            archiveBaseName.set("jvmMain")
////            from(compilation.output.classesDirs, compilation.compileDependencyFiles)
//            from(runTask.classpath)
//        }
        val jvmJar by tasks.getting(org.gradle.jvm.tasks.Jar::class) {
            manifest {
                attributes["Main-Class"] = "AppKt"
            }
            from(configurations.getByName("runtimeClasspath").map { if (it.isDirectory) it else zipTree(it) })
        }
    }
    sourceSets {
        "main".also { sourceSet ->
            val capitalized = sourceSet.capitalize()
            getByName("common$capitalized") {
                dependencies {
                    implementation(project(":common"))
                }
            }
            getByName("jvm$capitalized") {
                kotlin.srcDirs("src/jvm/$sourceSet/kotlin")
            }
        }
    }
}
