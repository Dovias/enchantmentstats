plugins {
    id("java")
    id("io.github.goooler.shadow") version "8.1.8" apply false
}

version = project.properties["version"]!!
group = project.properties["group"]!!

java {
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}