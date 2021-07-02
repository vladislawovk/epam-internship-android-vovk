package com.vladislawovk.epam_internship_android_vovk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val mealList: MutableList<Meal> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.meal_list_item,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mealList[position])
    }

    override fun getItemCount(): Int = mealList.size

    fun setMealList(list: List<Meal>) {
        this.mealList.clear()
        this.mealList.addAll(list)
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val mealListText: TextView = view.findViewById(R.id.meal_list_text)

        fun bind(model: Meal) {
            mealListText.text = model.mealText
        }
    }
}