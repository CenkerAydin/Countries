package com.cenkeraydin.countries.data.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val country_name :String?,
    @SerializedName("capital")
    val country_capital :String?,
    @SerializedName("region")
    val country_region :String?,
    @SerializedName("currency")
    val country_currency :String?,
    @SerializedName("language")
    val country_language :String?,
    @SerializedName("flag")
    val image_url :String?
)
