package com.cs.navigationdrawerbottomsheetcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cs.navigationdrawerbottomsheetcompose.screens.DashboardScreen
import com.cs.navigationdrawerbottomsheetcompose.screens.HelpScreen
import com.cs.navigationdrawerbottomsheetcompose.screens.HomeScreen
import com.cs.navigationdrawerbottomsheetcompose.screens.SettingScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DashboardScreen.route) {
        composable(Screen.DashboardScreen.route) {
            DashboardScreen(navController = navController)
           }
        composable(route = Screen.HomeScreen.route + "/{name}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                    defaultValue = "Hello Sumed"
                    nullable = true
                }
            )
            ){ entry ->
            HomeScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
                )
        }
        composable(route = Screen.SettingScreen.route){
            SettingScreen(navController = navController)
        }
        composable(route = Screen.HelpScreen.route){
            HelpScreen(navController = navController)
        }
    }

}