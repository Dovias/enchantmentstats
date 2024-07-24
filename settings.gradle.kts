rootProject.name = "enchantmentstats"

pluginManagement {
    repositories {
        maven {
            name = "Fabric"
            setUrl("https://maven.fabricmc.net")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

include("fabric")
include("fabric:1.21")
