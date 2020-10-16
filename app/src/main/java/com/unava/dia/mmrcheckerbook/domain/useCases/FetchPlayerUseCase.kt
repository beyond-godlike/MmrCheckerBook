package com.unava.dia.mmrcheckerbook.domain.useCases

import com.unava.dia.mmrcheckerbook.data.AccInformation
import retrofit2.Response


interface FetchPlayerUseCase {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation>
}