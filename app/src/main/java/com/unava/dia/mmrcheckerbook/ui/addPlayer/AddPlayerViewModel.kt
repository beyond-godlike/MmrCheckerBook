package com.unava.dia.mmrcheckerbook.ui.addPlayer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unava.dia.mmrcheckerbook.data.AccInformation
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AddPlayerViewModel @Inject constructor(private val model: AddPlayerModel) : ViewModel() {
    val requestError: MutableLiveData<String> = MutableLiveData()
    var accInfo: MutableLiveData<AccInformation> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun getPlayer(id: String) {
        scope.launch {
            try {
                val response = model.getPlayerInfoAsync(id)
                accInfo.postValue(response.body())
            } catch (e: Exception) {
                e.printStackTrace()
                requestError.postValue(e.localizedMessage)
            }
        }
    }

    fun deletePlayer(id: Int) {
        model.deletePlayer(id)
    }

    fun addPlayer() {
        if (accInfo.value != null) {
            // проверить есть ли плеер с таким acc_id если есть - update
            if(isPlayerInDatabase(accInfo.value?.profile?.account_id!!)) {
                //requestError.value = "updating"
            }
            else model.insertPlayer(accInfo.value!!)
        }
    }


    private fun isPlayerInDatabase(accId: Int) : Boolean {
        val entitiesList = model.getPlayersAsync()
        if (entitiesList != null) {
            for (entity in entitiesList) {
                if (entity.profile!!.account_id == accId) {
                    // update entity
					//change 
                    //model.updatePlayer(entity)
					// to 
					accInfo.value?.id = entity.id
                    requestError.value = "updating " + accInfo.value?.id
					model.updatePlayer(accInfo.value!!)
                    return true
                }
            }
        }
        return false
    }

    fun updatePlayer(id: Int) {
		accInfo.value!!.id = id
        model.updatePlayer(accInfo.value!!)
    }

    fun restorePlayerFromDatabase(playerId: Int) {
        accInfo.value = model.getPlayerAsync(playerId)
    }

    private fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }
}