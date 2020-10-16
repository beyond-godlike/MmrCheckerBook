package com.unava.dia.mmrcheckerbook.ui.main

import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import retrofit2.Response
import javax.inject.Inject

class MainModel @Inject constructor(private var useCase: FetchPlayerUseCase) {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return this.useCase.getPlayerInfoAsync(id)
    }
}