package com.enesfaruk.sportfreak.network

import com.enesfaruk.sportfreak.model.transfer.TransferTeamResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by Enes Faruk Işık on 4.08.2022.
 */
interface ApiFactory {
    //"https://v3.football.api-sports.io/transfers?team=463"
    @GET("transfers")
    suspend fun getTransfersByTeam(
        @Header("x-rapidapi-key") apiKey: String,
        @Query("team") team: String
    ): TransferTeamResponse
}