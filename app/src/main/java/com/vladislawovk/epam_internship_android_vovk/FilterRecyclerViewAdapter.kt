package com.vladislawovk.epam_internship_android_vovk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.network.MealDetails

class FilterRecyclerViewAdapter : RecyclerView.Adapter<FilterRecyclerViewAdapter.MyTopViewHolder>() {

    private val mealDetailsList: MutableList<MealDetails> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.meal_list_filter_item,
            parent,
            false
        )
        return MyTopViewHolder(view)
    }

    override fun onBindViewHolder(holderTop: MyTopViewHolder, position: Int) {
        holderTop.bind(mealDetailsList[position])
    }

    override fun getItemCount(): Int = mealDetailsList.size

    fun setFilterList(list: List<MealDetails>) {
        this.mealDetailsList.clear()
        this.mealDetailsList.addAll(list)
        notifyDataSetChanged()
    }

    class MyTopViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val filterListImage: ImageView = view.findViewById(R.id.meal_top_small_image)

        fun bind(model: MealDetails) {
//            filterListImage.setImageResource() = model.
        }
    }
}