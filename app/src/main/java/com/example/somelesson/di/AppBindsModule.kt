package com.example.somelesson.di

import com.example.somelesson.data.LampRepository
import com.example.somelesson.data.LampRepositoryImpl
import com.example.somelesson.domain.SetColorUseCase
import com.example.somelesson.domain.SetColorUseCaseImpl
import com.example.somelesson.domain.SetStateUseCase
import com.example.somelesson.domain.SetStateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {


    @Binds
    fun bindLampRepository(impl: LampRepositoryImpl): LampRepository

    @Binds
    fun bindSetStateUseCase(impl: SetStateUseCaseImpl): SetStateUseCase

    @Binds
    fun bindSetColorUseCase(impl: SetColorUseCaseImpl): SetColorUseCase
}