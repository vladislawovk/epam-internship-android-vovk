package com.vladislawovk.epam_internship_android_vovk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MealDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
    }

    companion object {
        fun newIntent(context: Context) {

        }
    }
}