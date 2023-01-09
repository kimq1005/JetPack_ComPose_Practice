package test.map.jetpack_compose_practice.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import test.map.jetpack_compose_practice.R
import test.map.jetpack_compose_practice.model.category.CategoryModel
import test.map.jetpack_compose_practice.model.category.ReverselifeModel
import test.map.jetpack_compose_practice.nanum_bold

@Composable
fun CategoryScreen() {

    val (searchtext, setsearchtext) = rememberSaveable {
        mutableStateOf("")
    }

    val viewModel = viewModel<CategoryViewModel>()

    dataset(viewModel)

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "와우") })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Text(
                    text = "견생\n역전",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = nanum_bold
                )

                Spacer(modifier = Modifier.width(5.dp))

                Box(modifier = Modifier.height(40.dp)) {
                    TextField(
                        value = searchtext,
                        onValueChange = setsearchtext,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.White
                        ),
                        trailingIcon = {
                            Icon(imageVector = Icons.Filled.Add,
                                contentDescription = "",
                                tint = Color.Blue)
                        }
                    )

//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "",
//                        modifier = Modifier
//                            .fillMaxHeight()
//                            .align(Alignment.CenterEnd)
//                            .width(30.dp)
//                            .background(Color.Red)
//                        )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_alarm_24),
                    contentDescription = null
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier
                .height(1.dp)
                .background(color = Color.Black)
                .padding(16.dp))


            Text(
                text = "Category",
                fontFamily = nanum_bold,
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {//
                items(viewModel.categoryModel) { categoryitem ->
                    Row {
                        CategoryItem(categoryModel = categoryitem)
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }


            }

            Spacer(modifier = Modifier.height(50.dp))

//sd
            Text(
                text = "견생역전을 꿈꿔요!",
                fontFamily = nanum_bold,
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(viewModel.reverselifeModel) { data ->
                    Row {
                        ReverslifeItem(reverselifeModel = data)
                        Spacer (modifier = Modifier.width(20.dp))
                    }
                }
            }
        }

    }
}

fun dataset(viewModel: CategoryViewModel) {
    val hi = CategoryModel(
        categoryImage = R.drawable.ic_baseline_alarm_24,
        categoryName = "하윙"
    )

    val hi2 = CategoryModel(
        categoryImage = R.drawable.ic_launcher_foreground,
        categoryName = "하윙1"
    )

    val hi3 = CategoryModel(
        categoryImage = R.drawable.ic_launcher_foreground,
        categoryName = "하윙2"
    )

    val hi4 = CategoryModel(
        categoryImage = R.drawable.ic_baseline_alarm_24,
        categoryName = "하윙3"
    )

    viewModel.categoryModel.add(hi)
    viewModel.categoryModel.add(hi2)
    viewModel.categoryModel.add(hi3)
    viewModel.categoryModel.add(hi4)

    val reverslife = ReverselifeModel(
        reverselifeImage = R.drawable.ic_baseline_alarm_24,
        reversetitle = "인생역전을 원하냐?"
    )

    viewModel.reverselifeModel.add(reverslife)

}


@Preview
@Composable
fun Preview() {
    CategoryScreen()
}