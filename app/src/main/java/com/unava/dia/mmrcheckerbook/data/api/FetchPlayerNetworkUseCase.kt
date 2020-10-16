package com.unava.dia.mmrcheckerbook.data.api

import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import retrofit2.Response

class FetchPlayerNetworkUseCase (private val api: APIInterface) : NetworkUseCase(), FetchPlayerUseCase {

    override suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return api.getPlayerInfo(id)
    }
}