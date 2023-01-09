package test.map.jetpack_compose_practice.ui.category

import android.view.View
import androidx.lifecycle.ViewModel
import test.map.jetpack_compose_practice.model.category.CategoryModel
import test.map.jetpack_compose_practice.model.category.ReverselifeModel

class CategoryViewModel:ViewModel() {

    val categoryModel:MutableList<CategoryModel> = arrayListOf()
    val reverselifeModel: MutableList<ReverselifeModel> = arrayListOf()

}