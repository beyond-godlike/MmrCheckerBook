package com.unava.dia.mmrcheckerbook.di

import android.content.Context
import com.unava.dia.mmrcheckerbook.data.api.APIInterface
import com.unava.dia.mmrcheckerbook.data.api.FetchPlayerNetworkUseCase
import com.unava.dia.mmrcheckerbook.data.api.RoomRepository
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import com.unava.dia.mmrcheckerbook.domain.useCases.RoomUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Singleton
    @Provides
    fun provideFetchPlayerUseCase(api: APIInterface): FetchPlayerUseCase {
        return FetchPlayerNetworkUseCase(api)
    }

    @Singleton
    @Provides
    fun provideRoomRepository(context: Context): RoomRepository {
        return RoomRepository(context)
    }

    @Singleton
    @Provides
    fun provideRoomCase(repository: RoomRepository): RoomUseCase {
        return RoomUseCase(repository)
    }

}