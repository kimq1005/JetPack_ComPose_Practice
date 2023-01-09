package test.map.jetpack_compose_practice.ui.main

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import test.map.jetpack_compose_practice.R
import test.map.jetpack_compose_practice.Utils.Companion.ANALYSIS
import test.map.jetpack_compose_practice.Utils.Companion.CALENDAR
import test.map.jetpack_compose_practice.Utils.Companion.SETTINGS
import test.map.jetpack_compose_practice.Utils.Companion.TIMELINE
import test.map.jetpack_compose_practice.ui.category.CategoryScreen
import test.map.jetpack_compose_practice.ui.category.TESTSCREEN_1
import test.map.jetpack_compose_practice.ui.category.TESTSCREEN_2
import test.map.jetpack_compose_practice.ui.category.TESTSCREEN_3

@Composable
fun MainScreen() {

}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf<BottomNavItem>(
        BottomNavItem.Calender,
        BottomNavItem.Timeline,
        BottomNavItem.Analysis,
        BottomNavItem.Settings
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Calender.screenroute) {
        composable(BottomNavItem.Calender.screenroute) {
            CategoryScreen()
        }
        composable(BottomNavItem.Timeline.screenroute) {
            TESTSCREEN_1()
        }
        composable(BottomNavItem.Analysis.screenroute) {
            TESTSCREEN_2()
        }

        composable(BottomNavItem.Settings.screenroute) {
            TESTSCREEN_3()
        }


    }

}


sealed class BottomNavItem(
    val title: Int, val icon: Int, val screenroute: String,
) {
    object Calender :
        BottomNavItem(R.string.bottomnavi_calender, R.drawable.ic_baseline_alarm_24, CALENDAR)

    object Timeline :
        BottomNavItem(R.string.bottomnavi_timeline, R.drawable.ic_baseline_alarm_24, TIMELINE)

    object Analysis :
        BottomNavItem(R.string.bottomnavi_analysis, R.drawable.ic_baseline_alarm_24, ANALYSIS)

    object Settings :
        BottomNavItem(R.string.bottomnavi_setting, R.drawable.ic_baseline_alarm_24, SETTINGS)
}

