plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
}


android {
    namespace = "com.ejemplo.medidorapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ejemplo.medidorapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        // }
        //composeOptions {
        //kotlinCompilerExtensionVersion = "1.4.8"
        //}
    }

    dependencies {

        ksp(libs.androidx.room.compiler)
        implementation(libs.androidx.core.ktx)
        implementation(libs.symbol.processing.api)
        // Compose
        implementation(libs.androidx.activity.compose.v180)
        implementation(libs.ui)
        implementation(libs.androidx.material)
        implementation(libs.ui.tooling.preview)
        debugImplementation(libs.ui.tooling)
        implementation(libs.androidx.ui.v150alpha01)

        // Navigation Compose

        implementation(libs.androidx.navigation.compose)

        // ROOM

        implementation(libs.androidx.room.runtime)

        implementation(libs.androidx.room.ktx)

        // ViewModel y LiveData

        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)

        // Coroutines
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        implementation(libs.androidx.monitor)
        implementation(libs.androidx.junit.ktx)
    }
}
