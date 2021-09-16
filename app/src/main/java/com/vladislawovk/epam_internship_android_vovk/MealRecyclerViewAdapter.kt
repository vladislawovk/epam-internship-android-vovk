package com.vladislawovk.epam_internship_android_vovk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.network.Meal

class MealRecyclerViewAdapter : RecyclerView.Adapter<MealRecyclerViewAdapter.MyMealViewHolder>() {

    private val mealList: MutableList<Meal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.meal_list_meal_item,
            parent,
            false
        )
        return MyMealViewHolder(view)
    }

    override fun onBindViewHolder(holderMeal: MyMealViewHolder, position: Int) {
        holderMeal.bind(model = mealList[position])
    }

    override fun getItemCount(): Int = mealList.size

    fun setMealList(list: List<Meal>) {
        this.mealList.clear()
        this.mealList.addAll(list)
        notifyDataSetChanged()
    }

    class MyMealViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mealListText: TextView = view.findViewById(R.id.meal_list_text)
        private val mealListImage: ImageView = itemView.findViewById(R.id.meal_list_image)

        fun bind(model: Meal) {
            mealListText.text = model.mealText
        }
    }
}