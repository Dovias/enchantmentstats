plugins {
    id("java-library")
    id("io.github.goooler.shadow")
    id("fabric-loom") version "1.7-SNAPSHOT" apply false
}

group = "${project.parent!!.group}.fabric"
version = project.parent!!.version

java {
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    maven {
        setUrl("https://maven.fabricmc.net/")
    }

    mavenCentral()
}

dependencies {
    implementation("net.fabricmc:fabric-loader:${project.properties["loader_version"]}")

    shadow(project(":"))
}


base {
    archivesName.set("${rootProject.name}-${project.name}")
}


tasks {
    shadowJar {
        configurations = listOf(project.configurations.shadow.get())

        archiveClassifier.set("shadow")
    }
}


