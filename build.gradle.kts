plugins {
    base
    kotlin("jvm") version "1.6.10" apply false
    application
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "application")

    tasks {
        named<Test>("test") {
            useJUnitPlatform {
            }
        }
    }
}

tasks {
    register("stage") {
        subprojects.forEach {
            dependsOn("${it.name}:installDist")
        }
    }
}