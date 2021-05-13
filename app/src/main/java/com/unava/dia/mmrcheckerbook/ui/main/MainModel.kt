package com.unava.dia.mmrcheckerbook.ui.main

import androidx.lifecycle.LiveData
import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import com.unava.dia.mmrcheckerbook.domain.useCases.RoomUseCase
import retrofit2.Response
import javax.inject.Inject

class MainModel @Inject constructor(
    private var dbUseCase: RoomUseCase,
    private val networkUseCase: FetchPlayerUseCase
) {
    fun getAllPlayers(): LiveData<List<AccInformation>>? {
        return this.dbUseCase.findAllPlayersAsync()
    }

    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return this.networkUseCase.getPlayerInfoAsync(id)
    }

    fun updatePlayer(player: AccInformation) {
        this.dbUseCase.updatePlayer(player)
    }

    fun getSteamId(id: Int) : String? {
        val playerId = this.dbUseCase.getPlayerAsync(id)?.profile?.account_id
        if(playerId != null) return playerId.toString()
        else return null
    }
}