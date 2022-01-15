plugins {
    base
    kotlin("jvm") version "1.6.10" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "java")
    apply(plugin = "kotlin")

}

dependencies {
}