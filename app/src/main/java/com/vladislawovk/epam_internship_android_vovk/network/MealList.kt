package com.vladislawovk.epam_internship_android_vovk.network

import com.google.gson.annotations.SerializedName

class MealList(
    @SerializedName("meals")
    val meals: List<Meal>
)