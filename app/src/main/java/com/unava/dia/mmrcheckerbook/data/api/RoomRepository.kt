package com.unava.dia.mmrcheckerbook.data.api

import android.content.Context
import com.unava.dia.mmrcheckerbook.data.AccInformation
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RoomRepository(context: Context) {
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    private val db: AppDatabase = AppDatabase.getAppDataBase(context)!!

    fun getPlayers() = db.playerDao().getPlayers()
    fun getPlayer(id: Int) = db.playerDao().getPlayer(id)

    fun getPlayerAsync(id: Int): AccInformation? = runBlocking(Dispatchers.Default) {
        return@runBlocking async { db.playerDao().getPlayerAsync(id) }.await()
    }
    fun getPlayersAsync(): List<AccInformation>? = runBlocking(Dispatchers.Default) {
        return@runBlocking async { db.playerDao().getPlayersAsync() }.await()
    }

    fun insertPlayer(player: AccInformation) {
        scope.launch  { db.playerDao().insertPlayer(player) }
    }

    fun updatePlayer(player: AccInformation) {
        scope.launch  { db.playerDao().updatePlayer(player) }
    }

    fun updatePlayer(id: Int) {
        scope.launch  { db.playerDao().updatePlayer(getPlayerAsync(id)!!) }
    }

    fun deletePlayer(player: AccInformation) {
        scope.launch  { db.playerDao().deletePlayer(player) }
    }

    fun deletePlayer(id: Int) {
        scope.launch  { db.playerDao().deletePlayer(getPlayerAsync(id)!!) }
    }
}