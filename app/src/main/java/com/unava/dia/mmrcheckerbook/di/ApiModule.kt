package com.unava.dia.mmrcheckerbook.di

import com.unava.dia.mmrcheckerbook.data.api.APIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : APIInterface {
        return retrofit.create(APIInterface::class.java)
    }
}