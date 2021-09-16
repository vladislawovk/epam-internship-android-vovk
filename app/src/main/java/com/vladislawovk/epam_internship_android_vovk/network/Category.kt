package com.vladislawovk.epam_internship_android_vovk.network

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: Int,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryThumb")
    val categoryThumb: String,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String
)