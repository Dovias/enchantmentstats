import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("java")
    id("fabric-loom")
    id("io.github.goooler.shadow")
}

group = "me.dovias.enchantips"
version = "1.0.0"

java {
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:${project.properties["minecraft_version"]}")
    mappings("net.fabricmc:yarn:${project.properties["yarn_mappings"]}:v2")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_version"]}")

    shadow(project(":fabric", "shadow"))
}

base {
    archivesName.set("${rootProject.name}-${project.parent?.name}-${project.version}+${project.name}")
}

tasks {
    build {
        dependsOn("remapShadowJar")
    }

    jar {
        archiveVersion.set("")
    }

    remapJar {
        archiveVersion.set("")
        archiveClassifier.set("remapped")
    }

    shadowJar {
        configurations = listOf(project.configurations.shadow.get())
        archiveVersion.set("")
        archiveClassifier.set("shadow-dev")

        destinationDirectory.set(jar.get().destinationDirectory)
    }

    register<RemapJarTask>("remapShadowJar") {
        inputFile.set(shadowJar.get().archiveFile)
        archiveVersion.set("")
        archiveClassifier.set("shadow-remapped")
    }
}
