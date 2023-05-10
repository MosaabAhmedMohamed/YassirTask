plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlin-parcelize")

}

android {
    namespace = "com.example.presentation"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(":core"))
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //Hilt
    implementation(Hilt.HILT)
    kapt(Hilt.HILT_ANDROID_COMPILER)

    //Coroutines
    implementation(Coroutines.COROUTINES_ANDROID)
    implementation(Coroutines.COROUTINES_CORE)

    implementation(Compose.COMPOSE_RUNTIME)

    //Paging 3
    implementation("androidx.paging:paging-runtime:3.1.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.mockito:mockito-inline:4.8.0")
    testImplementation("org.robolectric:robolectric:4.4")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation(TestingLib.androidxTestRunner)
    testImplementation(TestingLib.kluent)
    testImplementation(TestingLib.RoboElectric)
    testImplementation(TestingLib.mockito)
    testImplementation(TestingLib.mockito_inline)
    testImplementation(TestingLib.testing_core_testing)
    testImplementation(TestingLib.android_test_room)
    testImplementation(AndroidTestingLib.ANDROIDX_TEST_CORE)
}