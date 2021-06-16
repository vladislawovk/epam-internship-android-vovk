package com.vladislawovk.epam_internship_android_vovk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MealDetailsActivity : AppCompatActivity() {

    private val textView: TextView by lazy { findViewById(R.id.meal_country) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)

        val text = intent.getStringExtra("MEAL_COUNTRY")
        textView.text = text
    }
}