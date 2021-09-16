package com.vladislawovk.epam_internship_android_vovk.api

import com.vladislawovk.epam_internship_android_vovk.network.Category
import com.vladislawovk.epam_internship_android_vovk.network.Meal
import com.vladislawovk.epam_internship_android_vovk.network.MealDetails
import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Query

interface MealApi {

    @GET("categories.php")
    fun getCategories(): Single<List<Category>>

    @GET("filter.php")
    fun getMeals(@Query("c") categoryName: String): Single<List<Meal>>

    @GET("lookup.php")
    fun getMealDetails(@Query("i") id: Int):Single<List<MealDetails>>
}