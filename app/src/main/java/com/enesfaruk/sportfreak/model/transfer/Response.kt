package com.enesfaruk.sportfreak.model.transfer


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("player")
    val player: Player?,
    @SerializedName("transfers")
    val transfers: List<Transfer>?,
    @SerializedName("update")
    val update: String?
)