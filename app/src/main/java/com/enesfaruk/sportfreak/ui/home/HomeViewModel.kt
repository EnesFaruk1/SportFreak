package com.enesfaruk.sportfreak.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesfaruk.sportfreak.model.transfer.TransferTeamResponse
import com.enesfaruk.sportfreak.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Enes Faruk Işık on 11.08.2022.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val transferTeamResponse: MutableLiveData<TransferTeamResponse?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val onError: MutableLiveData<String?> = MutableLiveData()

    fun getTransferByTeam(
        apiKey: String,
        team: String
    ) = viewModelScope.launch {
        isLoading.value = true
        when (val request = repository.getTransferByTeam(apiKey, team)) {
            is NetworkResult.Success -> {
                transferTeamResponse.value = request.data
                isLoading.value = false
            }
            is NetworkResult.Error -> {
                onError.value = request.message
                isLoading.value = false
            }
        }
    }
}