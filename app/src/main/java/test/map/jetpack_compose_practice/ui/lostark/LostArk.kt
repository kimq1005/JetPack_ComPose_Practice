package test.map.jetpack_compose_practice.ui.lostark

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen1(viewmodel:Screen1ViewModel){
    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.Black,
                text = "Screen1",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen2(viewmodel:Screen2ViewModel){
    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.Green,
                text = "Screen2",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}


class Screen1ViewModel : ViewModel(){


}

class Screen2ViewModel : ViewModel(){


}




sealed class NavigationDestination(val destination: String) {
    object Screen1 : NavigationDestination("screen1")
    object Screen2 : NavigationDestination("screen2")
}