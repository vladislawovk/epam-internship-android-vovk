package com.vladislawovk.epam_internship_android_vovk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.network.Category

class CategoriesAdapter(private val clickListener: OnCategoryClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private val categoryList: MutableList<Category> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.meal_list_filter_item,
            parent,
            false
        )
        return CategoryViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(categoryHolder: CategoryViewHolder, position: Int) {
        categoryHolder.bind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    fun setFilterList(list: List<Category>) {
        this.categoryList.clear()
        this.categoryList.addAll(list)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(
        view: View,
        private val clickListener: OnCategoryClickListener
    ) : RecyclerView.ViewHolder(view) {

        val filterListImage: ImageView = view.findViewById(R.id.meal_top_small_image)

        fun bind(model: Category) {
//            filterListImage.setImageResource() = model.
            itemView.setOnClickListener {
                clickListener.onCategoryClick(model)
            }
        }
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(category: Category)
    }
}