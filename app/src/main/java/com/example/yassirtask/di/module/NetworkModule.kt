package com.example.yassirtask.di.module

import com.example.core.util.APIConst
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    internal fun provideHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(APIConst.TIME_OUT, TimeUnit.SECONDS)
        httpClient.readTimeout(APIConst.TIME_OUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(APIConst.TIME_OUT, TimeUnit.SECONDS)
        httpClient.retryOnConnectionFailure(true)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

       /* httpClient.addInterceptor(logging)
            .addInterceptor(AuthenticationInterceptor(BuildConfig.GRADLE_API_TOKEN))*/
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(APIConst.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}