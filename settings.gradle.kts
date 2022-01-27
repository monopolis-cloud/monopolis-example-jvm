plugins {
    id("de.fayard.refreshVersions") version "0.40.0"
}

refreshVersions {
}

rootDir.walkTopDown()
    .maxDepth(3)
    .filter { it.isDirectory && File(it, "build.gradle.kts").exists() }
    .filterNot { it == rootDir }
    .map { it.relativeTo(rootDir).path.replace('/', ':') }
    .forEach { include(it) }
