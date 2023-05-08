object Sdk {
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 33
    const val  COMPILE_SDK_VERSION = 33
}


object Versions {
    const val ANDROIDX_KTX = "1.1.1"
    const val ANDROIDX_TEST_EXT = "1.1.1"
    const val ANDROIDX_TEST = "1.4.0"
    const val ESPRESSO_CORE = "3.4.0"
    const val JUNIT = "4.13.2"
    const val KTLINT = "0.36.0"
    const val HILT = "2.44"
    const val HILT_COMPILER = "1.0.0"
    const val COROUTINES = "1.6.4"
    const val COMPOSE = "1.4.3"
    const val RoboElectric = "4.4"
    const val ROOM = "2.3.0"
    const val MOCKITO = "3.12.4"
    const val lifecycle = "1.1.1"
    const val HILT_NAVIGATION="1.0.0"
    const val NAVIGATION="2.5.3"
    const val DESTINATION ="1.8.41-beta"
    const val GSON = "2.10.1"
    const val Logging = "5.0.0-alpha.2"
    const val Coroutines = "1.6.4"
    const val Mockk = "1.12.5"
    const val kluent = "1.+"
    const val JUNITjupiter = "5.8.2"
    const val RETROFIT = "2.9.0"
    const val RETROFIT_COROU_ADAPTER = "0.9.2"

}

object BuildPluginsVersion {
    const val AGP = "7.3.1"
    const val DETEKT = "1.8.0"
    const val KOTLIN = "1.7.0"
    const val KTLINT = "9.2.1"
    const val VERSIONS_PLUGIN = "0.28.0"
}

object TestingLib {
   // const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val android_test_room = "androidx.room:room-testing:${Versions.ROOM}"
    const val testing_core_testing = "android.arch.core:core-testing:${Versions.lifecycle}"
    const val mockito = "org.mockito:mockito-core:${Versions.MOCKITO}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.MOCKITO}"
    const val RoboElectric = "org.robolectric:robolectric:${Versions.RoboElectric}"
    const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Coroutines}"
    const val mockk = "io.mockk:mockk:${Versions.Mockk}"
    const val kluent = "org.amshove.kluent:kluent-android:${Versions.kluent}"
    const val JUNITjupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNITjupiter}"
    const val JUNITjupiterEngin = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNITjupiter}"
    const val androidxTestRunner = "androidx.test:runner:1.+"
}

object AndroidKTX {
    const val ANDROIDX_KTX_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_KTX}"

}

object AndroidTestingLib {
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_CORE = "androidx.test:core:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}


object Hilt {
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_COMPLIER = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"
}

object Coroutines {
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
}

object Compose {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE}"
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"

}


object Navigation {
    const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION}"
    const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.NAVIGATION}"
    const val DESTINATION = "io.github.raamcosta.compose-destinations:core:${Versions.DESTINATION}"
    const val DESTINATION_KSP = "io.github.raamcosta.compose-destinations:ksp:${Versions.DESTINATION}"

}

object RETROFIT {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_JSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_COROU_ADAPTER = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROU_ADAPTER}"

}

object Logging{
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.Logging}"
}

object GSON{
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
}


