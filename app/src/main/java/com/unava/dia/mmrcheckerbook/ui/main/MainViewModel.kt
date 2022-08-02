package com.unava.dia.mmrcheckerbook.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.unava.dia.mmrcheckerbook.data.AccInformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val model: MainModel
) : ViewModel() {
    val requestError: MutableLiveData<String> = MutableLiveData()
    val updatingStatus: MutableLiveData<String> = MutableLiveData()
    var accInfo: MutableLiveData<AccInformation> = MutableLiveData()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun getPlayersList() = model.getAllPlayers()

    fun updatePlayer(id: Int) {
        // fetch new data from server
        val steamId = model.getSteamId(id)
        if (steamId != null) {
            scope.launch {
                try {
                    val response = model.getPlayerInfoAsync(steamId)
                    // update new data
                    if(response.body() != null) {
                        val entity = response.body()!!
                        entity.id = id
                        model.updatePlayer(entity)
                    }
                    accInfo.postValue(response.body())
                } catch (e: Exception) {
                    e.printStackTrace()
                    requestError.postValue(e.localizedMessage)
                }
            }
            // update new data
            if (accInfo.value != null)
            {
                //model.updatePlayer(accInfo.value!!)
                updatingStatus.value = "updating: " + accInfo.value!!.profile?.personaname
            }
        }
        else {
            updatingStatus.value = "profile is empty"
        }
    }
}