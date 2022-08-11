package com.enesfaruk.sportfreak.ui.home

import com.enesfaruk.sportfreak.base.BaseRepository
import com.enesfaruk.sportfreak.network.ApiFactory
import javax.inject.Inject

/**
 * Created by Enes Faruk Işık on 11.08.2022.
 */
class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {
    suspend fun getTransferByTeam(
        apiKey: String,
        team: String
    ) = safeApiRequest {
        apiFactory.getTransfersByTeam(apiKey, team)
    }
}