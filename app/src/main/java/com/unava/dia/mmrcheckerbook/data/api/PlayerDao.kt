package com.unava.dia.mmrcheckerbook.data.api

import androidx.lifecycle.LiveData
import androidx.room.*
import com.unava.dia.mmrcheckerbook.data.AccInformation

@Dao
interface PlayerDao {
    @Insert
    fun insertPlayer(player: AccInformation): Long?

    @Query("SELECT * from AccInformation")
    fun getPlayers() : LiveData<List<AccInformation>>

    @Query("SELECT * from AccInformation")
    fun getPlayersAsync(): List<AccInformation>

    @Query("SELECT * FROM AccInformation WHERE id =:playerId")
    fun getPlayer(playerId: Int): LiveData<AccInformation>

    @Query("SELECT * FROM AccInformation WHERE id =:playerId")
    fun getPlayerAsync(playerId: Int): AccInformation

    @Update
    fun updatePlayer(player: AccInformation)

    @Delete
    fun deletePlayer(player: AccInformation)

    @Query("SELECT COUNT(*) FROM AccInformation")
    fun countAllPlayers(): Int
}