package com.unava.dia.mmrcheckerbook.framework.useCases

import com.unava.dia.mmrcheckerbook.data.api.APIInterface
import com.unava.dia.mmrcheckerbook.data.api.FetchPlayerNetworkUseCase
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Singleton
    @Provides
    fun provideFetchPlayerUseCase(api: APIInterface): FetchPlayerUseCase {
        return FetchPlayerNetworkUseCase(api)
    }
}