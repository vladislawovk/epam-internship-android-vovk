package com.vladislawovk.epam_internship_android_vovk.api

import com.vladislawovk.epam_internship_android_vovk.network.CategoryList
import com.vladislawovk.epam_internship_android_vovk.network.MealDetailsList
import com.vladislawovk.epam_internship_android_vovk.network.MealList
import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Query

interface MealApi {

    @GET("categories.php")
    fun getCategories(): Single<CategoryList>

    @GET("filter.php")
    fun getMeals(@Query("c") categoryName: String): Single<MealList>

    @GET("lookup.php")
    fun getMealDetails(@Query("i") id: Int):Single<MealDetailsList>
}