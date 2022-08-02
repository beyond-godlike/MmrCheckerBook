package com.unava.dia.mmrcheckerbook.di

import com.unava.dia.mmrcheckerbook.BuildConfig
import com.unava.dia.mmrcheckerbook.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return RetrofitFactory.retrofit(BuildConfig.SERVER_URL + "/")
    }
}