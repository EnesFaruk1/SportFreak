package com.enesfaruk.sportfreak.base

import com.enesfaruk.sportfreak.model.transfer.TransferTeamResponse
import com.enesfaruk.sportfreak.utils.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

/**
 * Created by Enes Faruk Işık on 4.08.2022.
 */
abstract class BaseRepository {

    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T): NetworkResult<T> {
        return withContext(Dispatchers.IO){
            try {
                NetworkResult.Success(apiRequest.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        NetworkResult.Error(false, errorBodyParser(throwable.response()?.message()))
                    }
                    else -> NetworkResult.Error(true, throwable.localizedMessage)
                }
            }
        }
    }
}

private fun errorBodyParser(error: String?): String{
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(it, TransferTeamResponse::class.java)
            val errorMessage = errorResponse.errors?.get(0).toString()
            errorMessage ?: "Unexpected error"
        }catch (e: Exception){
            "Unexpected error"
        }
    }
    return "Unexpected error"
}