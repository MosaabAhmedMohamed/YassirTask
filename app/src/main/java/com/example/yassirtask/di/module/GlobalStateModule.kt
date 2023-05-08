package com.example.yassirtask.di.module


import com.example.presentation.base.GlobalState
import com.example.presentation.base.IGlobalState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GlobalStateModule {

    @Provides
    fun provideGlobalState() : IGlobalState = GlobalState()
}