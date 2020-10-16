package com.unava.dia.mmrcheckerbook.framework.network

import com.google.gson.Gson
import com.unava.dia.mmrcheckerbook.BuildConfig
import com.unava.dia.mmrcheckerbook.data.api.RetrofitFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return RetrofitFactory.createApiRetrofit(
            gson,
            BuildConfig.SERVER_URL + "/"
        )
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return Gson()
    }
}