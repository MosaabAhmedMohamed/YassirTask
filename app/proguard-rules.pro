# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.google.** { *; }

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}
-dontwarn android.support.v7.**
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.* { *; }
-keepattributes *Annotation,Signature
-dontwarn com.github.siyamed.**

#retrofit
-dontwarn javax.annotation.**
-dontwarn retrofit2.Platform$Java8
-dontwarn org.apache.commons.**
-keep class org.apache.http.** { *; }
-dontwarn org.apache.http.**
-dontwarn okio.**
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions, InnerClasses,EnclosingMethod
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}


##---------------Begin: proguard configuration for Gson ----------
# Gson uses generic type information stored in a class file when working with
#fields. Proguard removes such information by default, so configure it to keep
#all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson ----------



# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

-keepclasseswithmembers class * {
    @com.squareup.moshi.* <methods>;
}

-keep @com.squareup.moshi.JsonQualifier interface *

# Enum field names are used by the integrated EnumJsonAdapter.
# values() is synthesized by the Kotlin compiler and is used by EnumJsonAdapter indirectly
# Annotate enums with @JsonClass(generateAdapter = false) to use them with Moshi.
-keepclassmembers @com.squareup.moshi.JsonClass class * extends java.lang.Enum {
    <fields>;
    **[] values();
}

# Keep helper method to avoid R8 optimisation that would keep all Kotlin Metadata when unwanted
-keepclassmembers class com.squareup.moshi.internal.Util {
    private static java.lang.String getKotlinMetadataClassName();
}


# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform

-dontwarn com.google.errorprone.annotations.**

#arch-lifecycle
-keep class android.arch.lifecycle.** {*;}


-keep class com.example.core.base.**{*;}

-keep public class * extends java.lang.Exception

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.-KotlinExtensions

-ignorewarnings

-dontnote okio.**

-dontoptimize

-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.** { *; }


-dontwarn android.support.v7.**
-keep public class android.support.v7.** { *; }
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.* { *; }
-keepattributes *Annotation,Signature
-keepattributes *Annotation*
-dontwarn com.github.siyamed.**
-keep class com.github.siyamed.shapeimageview.**{ *; }

-keepattributes Signature

#retrofit
-dontwarn javax.annotation.**
-dontwarn retrofit2.Platform$Java8
-dontwarn org.apache.commons.**
-keep class org.apache.http.** { *; }
-dontwarn org.apache.http.**
-dontwarn okio.**
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions, InnerClasses,EnclosingMethod
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}



# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform

##---------------Begin: proguard configuration for Gson ----------
# Gson uses generic type information stored in a class file when working with
#fields. Proguard removes such information by default, so configure it to keep
#all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson ----------



#glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

-keep public class com.github.bumptech.glide.** { *; }

-keep public class com.google.dagger.** { *; }

-dontwarn com.google.errorprone.annotations.**

#arch-lifecycle
-keep class android.arch.lifecycle.** {*;}



-keepclassmembernames interface * {
    @retrofit2.http.* <methods>;
}

-ignorewarnings

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-dontoptimize

-keep public class  com.marlonmafra.android.widget.** { *; }

-keep public class  com.afollestad.** { *; }

-keep public class * extends java.lang.Exception

-keep public class  com.github.tbruyelle.** { *; }

-keep public class com.google.android.exoplayer.** { *; }

-keep public class com.theartofdev.edmodo.** { *; }

-keep public class de.hdodenhof.** { *; }

-keep public class com.github.yalantis.** { *; }

-keep public class com.github.pwittchen.** { *; }

-keep public class com.airbnb.android.** { *; }

-keep public class com.jaychang.** { *; }

-keep public class com.github.anastr.** { *; }

-keep public class com.shuhart.bubblepagerindicator.** { *; }

-keep public class com.github.qoqa.** { *; }

-keep public class net.yslibrary.keyboardvisibilityevent.** { *; }

-keep public class id.zelory.** { *; }

-keep public class com.jakewharton.picasso.** { *; }

-keep public class jp.wasabeef.** { *; }

-keep public class com.github.MindorksOpenSource.** { *; }

-keep public class com.ethanhua.** { *; }

-keep public class io.supercharge.** { *; }

-keep public class com.github.rasoulmiri.** { *; }

-keep public class androidx.mediarouter.** { *; }

-keep public class com.google.android.** { *; }

-keep public class com.github.mmin18.** { *; }

-keep public class cn.carbswang.android.** { *; }

-keep public class fr.tvbarthel.blurdialogfragment.** { *; }

-keep public class com.google.guava.** { *; }

-keep public class androidx.viewpager2.** { *; }

-keep public class com.google.android.material.** { *; }

-keep public class com.google.android.play.** { *; }

-keep public class androidx.recyclerview.** { *; }

-keep public class com.intuit.sdp.** { *; }

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keep class kotlinx.coroutines.android.AndroidExceptionPreHandler
-keep class kotlinx.coroutines.android.AndroidDispatcherFactory


-keepclassmembers class androidx.compose.ui.platform.ViewLayerContainer {
    protected void dispatchGetDisplayList();
}

-keepclassmembers class androidx.compose.ui.platform.AndroidComposeView {
    android.view.View findViewByAccessibilityIdTraversal(int);
}
-keep,allowshrinking class * extends androidx.compose.ui.node.ModifierNodeElement