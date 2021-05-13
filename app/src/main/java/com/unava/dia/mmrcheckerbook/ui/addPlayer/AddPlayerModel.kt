package com.unava.dia.mmrcheckerbook.ui.addPlayer

import androidx.lifecycle.LiveData
import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.domain.useCases.FetchPlayerUseCase
import com.unava.dia.mmrcheckerbook.domain.useCases.RoomUseCase
import retrofit2.Response
import javax.inject.Inject

class AddPlayerModel @Inject constructor(
    private var useCase: FetchPlayerUseCase,
    private val dbUseCase: RoomUseCase
) {
    suspend fun getPlayerInfoAsync(id: String): Response<AccInformation> {
        return this.useCase.getPlayerInfoAsync(id)
    }

    fun deletePlayer(id: Int) {
        this.dbUseCase.deletePlayer(id)
    }

    fun insertPlayer(player: AccInformation) {
        this.dbUseCase.insertPlayer(player)
    }

    fun updatePlayer(id: Int) {
        this.dbUseCase.updatePlayer(id)
    }

    fun updatePlayer(player: AccInformation) {
        this.dbUseCase.updatePlayer(player)
    }

    fun getPlayer(playerId: Int) : LiveData<AccInformation> {
        return this.dbUseCase.getPlayer(playerId)
    }

    fun getPlayerAsync(playerId: Int) : AccInformation? {
        return  this.dbUseCase.getPlayerAsync(playerId)
    }

    fun getPlayersAsync() : List<AccInformation>? {
        return this.dbUseCase.getPlayersAsync()
    }
}