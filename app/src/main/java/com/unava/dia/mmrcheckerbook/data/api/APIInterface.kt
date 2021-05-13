package com.unava.dia.mmrcheckerbook.data.api

import com.unava.dia.mmrcheckerbook.data.AccInformation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("players/{accountId}")
    suspend fun getPlayerInfo(@Path("accountId") accountId: String): Response<AccInformation>
}