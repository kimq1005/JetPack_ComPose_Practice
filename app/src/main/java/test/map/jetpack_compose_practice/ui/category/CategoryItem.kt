package test.map.jetpack_compose_practice.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import test.map.jetpack_compose_practice.R
import test.map.jetpack_compose_practice.model.category.CategoryModel

@Composable
fun CategoryItem(
    categoryModel: CategoryModel
){
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
//      AsyncImage(
//          model = categoryModel.categoryImage,
//          contentDescription = null ,
//          contentScale = ContentScale.Crop,
//      )

      Image(painter = painterResource(id = R.drawable.ic_baseline_alarm_24), contentDescription = null )
      Spacer(modifier = Modifier.height(5.dp))

      Text(text = categoryModel.categoryName)
  }
}

@Preview
@Composable
fun CategoryPreview(){
    val categoryModel =
        CategoryModel(
            categoryImage = R.drawable.ic_baseline_alarm_24,
            categoryName = "하윙"
        )

    CategoryItem(categoryModel = categoryModel)
}