import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("java")
    id("fabric-loom")
    id("io.github.goooler.shadow")
}

group = project.parent!!.group
version = project.parent!!.version

base {
    archivesName.set("${rootProject.name}-${project.parent?.name}-${project.version}+${project.name}")
}

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

    modImplementation("net.fabricmc:fabric-loader:${project.parent!!.properties["loader_version"]}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_version"]}")

    shadow(project(":fabric", "shadow"))
}

tasks {
    processResources {
        filesMatching("fabric.mod.json") {
            expand(
                "mod_name" to rootProject.properties["mod_name"],
                "mod_version" to project.version,
                "mod_description" to rootProject.properties["mod_description"],
                "mod_homepage" to rootProject.properties["mod_homepage"],
                "mod_issues" to rootProject.properties["mod_issues"],
                "mod_sources" to rootProject.properties["mod_sources"],
                "mod_license" to rootProject.properties["mod_license"],
                "mod_icon" to rootProject.properties["mod_icon"],
            )
        }
    }

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
