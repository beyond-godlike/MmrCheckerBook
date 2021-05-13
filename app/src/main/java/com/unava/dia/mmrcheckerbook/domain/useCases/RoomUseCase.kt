package com.unava.dia.mmrcheckerbook.domain.useCases

import androidx.lifecycle.LiveData
import com.unava.dia.mmrcheckerbook.data.AccInformation
import com.unava.dia.mmrcheckerbook.data.api.RoomRepository
import javax.inject.Inject

class RoomUseCase @Inject constructor(private var repository: RoomRepository) {

    fun findAllPlayersAsync(): LiveData<List<AccInformation>>? {
        return repository.getPlayers()
    }

    fun getPlayersAsync(): List<AccInformation>? {
        return repository.getPlayersAsync()
    }

    fun getPlayerAsync(id: Int) : AccInformation? {
        return  repository.getPlayerAsync(id)
    }

    fun getPlayer(id: Int): LiveData<AccInformation> {
        return repository.getPlayer(id)
    }

    fun deletePlayer(id: Int) {
        repository.deletePlayer(id)
    }

    fun updatePlayer(player: AccInformation) {
        repository.updatePlayer(player)
    }

    fun updatePlayer(id: Int) {
        repository.updatePlayer(id)
    }

    fun insertPlayer(player: AccInformation) {
        repository.insertPlayer(player)
    }
}