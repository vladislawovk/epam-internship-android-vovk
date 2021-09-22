package com.vladislawovk.epam_internship_android_vovk.network

import com.google.gson.annotations.SerializedName

class CategoryList(
    @SerializedName("categories")
    val categories: List<Category>
)
