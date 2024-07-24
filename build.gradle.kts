plugins {
    id("java")
    id("io.github.goooler.shadow") version "8.1.8" apply false
}

group = "me.dovias.${project.name}"
version = "0.0.1"

java {
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}