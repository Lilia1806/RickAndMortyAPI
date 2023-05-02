plugins {
    id("com.android.application")
    kotlin("android")

    //Navigation
    id("androidx.navigation.safeargs")

    //Kapt
    kotlin("kapt")

    //Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.rickandmortyapi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.rickandmortyapi"
        minSdk = 26
        targetSdk = 33
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
    buildFeatures {
        //ViewBinding
        viewBinding = true
    }
}

dependencies {

    //Core
    implementation("androidx.core:core-ktx:1.10.0")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    //Material Design
    implementation("com.google.android.material:material:1.8.0")

    //UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit 2
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    //Gson
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Navigation
    val navVersion = "2.5.3"
    //   implementation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //view pager
    implementation("androidx.viewpager2:viewpager2:1.1.0-beta01")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    //View binding property delegate
    val view_binding_property_delegate = "1.5.3"

    //To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // paging 3
    val paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    //hilt
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")

//    //Room
//    val room_version = ("2.4.3")
//
//    //noinspection GradleDependency
//    implementation("androidx.room:room-runtime:$room_version")
//    kapt("androidx.room:room-compiler:$room_version")
}