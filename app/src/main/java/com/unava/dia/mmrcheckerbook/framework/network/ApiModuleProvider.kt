package com.unava.dia.mmrcheckerbook.framework.network

import retrofit2.Retrofit

interface ApiModuleProvider<T> {
    fun provideApi(retrofit: Retrofit): T
}