package com.enesfaruk.sportfreak.model.transfer


import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("in")
    val inX: In?,
    @SerializedName("out")
    val `out`: Out?
)