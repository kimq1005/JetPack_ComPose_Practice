package test.map.jetpack_compose_practice.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import test.map.jetpack_compose_practice.R
import test.map.jetpack_compose_practice.model.category.ReverselifeModel

@Composable
fun ReverslifeItem(
    reverselifeModel: ReverselifeModel,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//      AsyncImage(
//          model = categoryModel.categoryImage,
//          contentDescription = null ,
//          contentScale = ContentScale.Crop,
//      )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.width(50.dp).height(50.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = reverselifeModel.reversetitle)
    }
}