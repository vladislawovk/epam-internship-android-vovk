package com.vladislawovk.epam_internship_android_vovk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.epam_internship_android_vovk.CategoriesAdapter
import com.vladislawovk.epam_internship_android_vovk.MealAdapter
import com.vladislawovk.epam_internship_android_vovk.R
import com.vladislawovk.epam_internship_android_vovk.api.RetrofitInstance
import com.vladislawovk.epam_internship_android_vovk.network.Category
import com.vladislawovk.epam_internship_android_vovk.network.Meal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MealListFragment : Fragment(),
    CategoriesAdapter.OnCategoryClickListener {

    private var categoriesAdapter: CategoriesAdapter? = null
    private var mealsAdapter: MealAdapter? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_meal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mealsAdapter = MealAdapter()
        view.findViewById<RecyclerView>(R.id.meal_recycler_view)?.adapter = mealsAdapter
        categoriesAdapter = CategoriesAdapter(this)
        view.findViewById<RecyclerView>(R.id.filter_recycler_view)?.adapter = categoriesAdapter

        loadCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun loadCategories() {
        RetrofitInstance.api.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ categoryList ->
                categoriesAdapter?.setFilterList(categoryList.categories)
                categoryList.categories.firstOrNull()?.let { firstCategory->
                    loadMeals(firstCategory.categoryName)
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
            .also {
                compositeDisposable.add(it)
            }

    }

    private fun loadMeals(categoryId: String) {
        RetrofitInstance.api.getMeals(categoryId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mealList ->
                mealsAdapter?.setMealList(mealList.meals)
            }, { throwable ->
                throwable.printStackTrace()
            })
            .also {
                compositeDisposable.add(it)
            }

    }

    override fun onCategoryClick(category: Category) {
        loadMeals(category.categoryName)
    }
}
