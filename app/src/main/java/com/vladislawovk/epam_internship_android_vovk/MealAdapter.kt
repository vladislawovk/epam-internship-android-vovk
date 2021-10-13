package com.vladislawovk.epam_internship_android_vovk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.network.Meal

class MealAdapter(private val clickListener: OnMealClickListener) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    private val mealList: MutableList<Meal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.meal_list_meal_item,
            parent,
            false
        )
        return MealViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(mealHolder: MealViewHolder, position: Int) {
        mealHolder.bind(model = mealList[position])
    }

    override fun getItemCount(): Int = mealList.size

    fun setMealList(list: List<Meal>) {
        this.mealList.clear()
        this.mealList.addAll(list)
        notifyDataSetChanged()
    }

    class MealViewHolder(
        view: View,
        private val clickListener: OnMealClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val mealListText: TextView = view.findViewById(R.id.meal_list_text)
        private val mealListImage: ImageView = itemView.findViewById(R.id.meal_list_image)

        fun bind(model: Meal) {
//            mealListText.text = model.mealText
            itemView.setOnClickListener {
                clickListener.onMealClick(model)
            }
        }
    }

    interface OnMealClickListener {
        fun onMealClick(meal: Meal)
    }
}