package com.vladislawovk.epam_internship_android_vovk

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MealListActivity : AppCompatActivity() {

    private val imageView: ImageView by lazy { findViewById(R.id.meal_small_image) }
    private val textView: TextView by lazy { findViewById(R.id.meal_list_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_list)

        imageView.setOnClickListener {
            startMealDetailsActivity(this)
        }

        textView.setOnClickListener {
            startMealDetailsActivity(this)
        }
    }

    private fun startMealDetailsActivity(context: Context) {
        val intent = Intent(context, MealDetailsActivity::class.java)
        startActivity(intent)
    }
}