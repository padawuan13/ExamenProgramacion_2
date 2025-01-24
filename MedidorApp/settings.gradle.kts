pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        // Versión AGP
        id("com.android.application") version "8.8.0"
        // Versión Kotlin
        id("org.jetbrains.kotlin.android") version "2.0.0"
        // Versión KSP (a juego con Kotlin 1.8.20)
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
        id("com.google.devtools.ksp") version "2.0.0-1.0.22"
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MedidorApp"
include(":app")
