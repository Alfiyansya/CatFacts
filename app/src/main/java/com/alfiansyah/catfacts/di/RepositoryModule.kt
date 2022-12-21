package com.alfiansyah.catfacts.di

import com.alfiansyah.catfacts.data.repository.CatFactRepository
import com.alfiansyah.catfacts.service.api.CatFactService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCatFactRepository(
        catFactService: CatFactService
    ): CatFactRepository =
        CatFactRepository(catFactService)
}