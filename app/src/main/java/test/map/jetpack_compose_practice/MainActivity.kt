package test.map.jetpack_compose_practice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import test.map.jetpack_compose_practice.Utils.Companion.TAG
import test.map.jetpack_compose_practice.ui.lostark.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()


//            val car: Car by inject()
//            car.startCar()

//            val navController = rememberNavController()
//
//            Scaffold(
//                topBar = { TopAppBar(title = { Text(text = "asdasd") }) },
//                bottomBar = {
//                    test.map.jetpack_compose_practice.ui.bottomnavi.BottomNavigation(
//                        navController = navController)
//                }
//            ) {
//                NavigationGraph(navController = navController)
//            }
//            NaverMapScreen()
//
//            KaKaoLoginScreen()
    }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TestScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {

    val (name, setname) = rememberSaveable {
        mutableStateOf(" ")
    }

    val (password, setpassword) = rememberSaveable {
        mutableStateOf(" ")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("????????? ??????") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = setname,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "??????") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go))
//
            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth())

            OutlinedTextField(
                value = password,
                onValueChange = setpassword,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "????????????") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go))

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(onClick = {
                    Log.d(TAG, "MainScreen: $name}")
                    viewModel.name.value == "dasdasd"
                    navController.navigate("result")
                }) {
                    Text(text = "???????????????")
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ResultScreen(navController: NavController, mainViewModel: MainViewModel) {

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "?????????")},
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "",
            Modifier.clickable { navController.popBackStack() })
        })}) { _ ->
        Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(mainViewModel.name.value, fontSize = 16.sp, modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth(), color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            Text(mainViewModel.password.toString(),
                fontSize = 14.sp,
                modifier = Modifier.background(Color.Red),
                color = Color.White)
        }
    }

}
