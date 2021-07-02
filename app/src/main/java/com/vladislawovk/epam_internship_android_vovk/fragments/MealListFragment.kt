package com.vladislawovk.epam_internship_android_vovk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.Meal
import com.vladislawovk.epam_internship_android_vovk.MyAdapter
import com.vladislawovk.epam_internship_android_vovk.R

class MealListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRecyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view)
        val myAdapter = MyAdapter()
        myRecyclerView.layoutManager = LinearLayoutManager(view.context)
        myRecyclerView.adapter = myAdapter

        myAdapter.setMealList(
            listOf(
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots"),
                Meal("Soy-Glazed Meatloaves with Wasabi Mashed Potatoes Roasted Carrots")
            )
        )
    }
}
