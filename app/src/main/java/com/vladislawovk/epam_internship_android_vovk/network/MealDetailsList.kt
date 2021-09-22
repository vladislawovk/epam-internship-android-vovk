package com.vladislawovk.epam_internship_android_vovk.network

import com.google.gson.annotations.SerializedName

class MealDetailsList(
    @SerializedName("meals")
    val mealDetails: List<MealDetails>
)