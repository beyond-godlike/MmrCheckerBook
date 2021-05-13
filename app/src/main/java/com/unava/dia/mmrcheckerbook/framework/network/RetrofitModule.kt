package com.unava.dia.mmrcheckerbook.framework.network

import com.unava.dia.mmrcheckerbook.BuildConfig
import com.unava.dia.mmrcheckerbook.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return RetrofitFactory.retrofit(BuildConfig.SERVER_URL + "/")
    }
}