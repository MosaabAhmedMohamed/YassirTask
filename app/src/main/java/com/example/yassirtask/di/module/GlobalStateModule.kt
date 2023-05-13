package com.example.yassirtask.di.module


import com.example.presentation.base.GlobalState
import com.example.presentation.base.IGlobalState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GlobalStateModule {

    @Singleton
    @Provides
    fun provideGlobalState() : IGlobalState = GlobalState()
}