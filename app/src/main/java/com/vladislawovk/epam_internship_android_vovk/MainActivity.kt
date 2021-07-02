package com.vladislawovk.epam_internship_android_vovk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vladislawovk.epam_internship_android_vovk.fragments.MealListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealListFragment = MealListFragment()

        supportFragmentManager
            .beginTransaction().apply {
                replace(R.id.fragment_container, mealListFragment)
                commit()
            }
    }
}