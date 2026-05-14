plugins {

    alias(libs.plugins.android.application)

    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)

    id("com.google.gms.google-services")
    alias(libs.plugins.kotlin.android)
}

android {

    namespace = "com.example.rbhapp"

    compileSdk = 36

    defaultConfig {

        applicationId = "com.example.rbhapp"

        minSdk = 24

        targetSdk = 36

        versionCode = 1

        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),

                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }

    buildFeatures {

        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // Compose

    implementation(
        "androidx.activity:activity-compose:1.9.0"
    )

    implementation(
        "androidx.compose.ui:ui:1.6.8"
    )

    implementation(
        "androidx.compose.material3:material3:1.2.1"
    )

    implementation(
        "androidx.compose.ui:ui-tooling-preview:1.6.8"
    )


    debugImplementation(
        "androidx.compose.ui:ui-tooling:1.6.8"
    )

    // ViewModel

    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0"
    )

    // Firebase

    implementation(
        "com.google.firebase:firebase-auth:23.0.0"
    )

    implementation(
        "com.google.firebase:firebase-firestore:25.1.0"
    )
    // Room Database

    implementation(libs.androidx.room.runtime)

    implementation(libs.androidx.room.ktx)

    add(
        "ksp",
        libs.androidx.room.compiler
    )

    // Existing

    implementation(libs.androidx.activity.ktx)

    implementation(libs.androidx.appcompat)

    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.core.ktx)

    implementation(libs.material)

    testImplementation(libs.junit)

    androidTestImplementation(
        libs.androidx.espresso.core
    )

    androidTestImplementation(
        libs.androidx.junit
    )
}