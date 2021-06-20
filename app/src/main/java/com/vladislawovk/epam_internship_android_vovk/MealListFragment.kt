package com.vladislawovk.epam_internship_android_vovk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MealListFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<ImageView>(R.id.meal_small_image).setOnClickListener(this)
        view.findViewById<TextView>(R.id.meal_list_text).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val imageAction = MealListFragmentDirections.navigateToMealDetailsFragment("USA")
        val textAction = MealListFragmentDirections.navigateToMealDetailsFragment("MEXICAN")
        when(view?.id) {
            R.id.meal_small_image -> navController.navigate(imageAction)
            R.id.meal_list_text -> navController.navigate(textAction)
        }
    }
}
