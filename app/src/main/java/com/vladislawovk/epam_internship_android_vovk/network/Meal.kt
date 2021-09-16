package com.vladislawovk.epam_internship_android_vovk.network

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("strMealThumb")
    val mealThumb: String,
    @SerializedName("strMeal")
    val mealName: String,
    @SerializedName("idMeal")
    val id: Int
)