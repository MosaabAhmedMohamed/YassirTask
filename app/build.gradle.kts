plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version("1.8.0-1.0.9")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        applicationId = AppCoordinates.APP_ID
        versionCode = AppCoordinates.APP_VERSION_CODE
        versionName = AppCoordinates.APP_VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    android.buildFeatures.compose = true
}

dependencies {

    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(kotlin("stdlib-jdk7"))
    implementation("androidx.appcompat:appcompat:1.6.1")

    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_RULES)
    androidTestImplementation(AndroidTestingLib.ESPRESSO_CORE)

    //Compose
    implementation(Compose.COMPOSE_UI)
    implementation(Compose.COMPOSE_MATERIAL)
    implementation(Compose.COMPOSE_PREVIEW)
    implementation(Compose.COMPOSE_ACTIVITY)
    implementation(Compose.COMPOSE_VIEWMODEL)
    implementation(AndroidKTX.ANDROIDX_KTX_RUNTIME)
    implementation(Compose.COMPOSE_RUNTIME)

    // Navigation
    implementation(Navigation.HILT_NAVIGATION)
    implementation(Navigation.NAVIGATION)
    implementation(Navigation.DESTINATION)
    ksp(Navigation.DESTINATION_KSP)

    // RETROFIT
    implementation(RETROFIT.RETROFIT)
    implementation(RETROFIT.RETROFIT_COROU_ADAPTER)
    implementation(RETROFIT.RETROFIT_JSON_CONVERTER)
    implementation(Logging.LOGGING)
    implementation(GSON.GSON)


    //Coroutines
    implementation(Coroutines.COROUTINES_ANDROID)
    implementation(Coroutines.COROUTINES_CORE)

    //Hilt
    implementation(Hilt.HILT)
    kapt(Hilt.HILT_ANDROID_COMPILER)
    kapt(Hilt.HILT_COMPLIER)

    implementation("io.coil-kt:coil-compose:2.2.0")

    //Paging 3
    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha19")

}