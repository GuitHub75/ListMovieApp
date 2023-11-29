plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.cocodev2500.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cocodev2500.movieapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //add Binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

      //Retrofit for API calls
     implementation("com.squareup.retrofit2:retrofit:2.9.0")
     implementation("com.squareup.retrofit2:converter-gson:2.9.0")
     implementation("com.google.code.gson:gson:2.9.0")

     //viewModel and liveData for MVVM pattern
     implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //Glide for images and gifs
    implementation("com.github.bumptech.glide:glide:4.13.0")

    //Coroutines for async calls
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    //circular progress bar
    implementation("com.github.antonKozyriatskyi:CircularProgressIndicator:1.3.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}