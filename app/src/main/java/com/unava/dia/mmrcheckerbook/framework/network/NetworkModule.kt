package com.unava.dia.mmrcheckerbook.framework.network

import dagger.Module

@Module(includes = [
    RetrofitModule::class,
    ApiModule::class
])
abstract class NetworkModule
