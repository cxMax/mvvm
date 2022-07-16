package com.fiture.mvvm.data.di

import com.fiture.mvvm.data.repository.MainDataRepository
import com.fiture.mvvm.data.repository.MainDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * Created by caixi on 2022/6/21.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun mainDataRepository(impl: MainDataRepositoryImpl): MainDataRepository
}