package com.unava.dia.mmrcheckerbook.di

import android.app.Application
import android.content.Context
import com.unava.dia.mmrcheckerbook.data.api.APIInterface
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import com.unava.dia.mmrcheckerbook.domain.useCases.RoomUseCase
import com.unava.dia.mmrcheckerbook.ui.addPlayer.AddPlayerModel
import com.unava.dia.mmrcheckerbook.ui.main.MainModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provedeMainModel(dbUseCase: RoomUseCase, networkUseCase: FetchPlayerUseCase) : MainModel {
        return MainModel(dbUseCase, networkUseCase)
    }

    @Provides
    @Singleton
    fun provedeAddPalyerModel(useCase: FetchPlayerUseCase, dbUseCase: RoomUseCase) : AddPlayerModel {
        return AddPlayerModel(useCase, dbUseCase)
    }
}