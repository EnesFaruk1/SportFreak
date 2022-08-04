package com.enesfaruk.sportfreak.model.transfer


import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("team")
    val team: String?
)