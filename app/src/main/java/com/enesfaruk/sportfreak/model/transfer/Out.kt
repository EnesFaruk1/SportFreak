package com.enesfaruk.sportfreak.model.transfer


import com.google.gson.annotations.SerializedName

data class Out(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("name")
    val name: String?
)