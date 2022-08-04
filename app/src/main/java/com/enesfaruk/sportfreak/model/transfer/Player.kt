package com.enesfaruk.sportfreak.model.transfer


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)