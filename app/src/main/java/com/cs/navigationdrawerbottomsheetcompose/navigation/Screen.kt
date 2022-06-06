package com.cs.navigationdrawerbottomsheetcompose.navigation

sealed class Screen(val route: String){
    object  DashboardScreen : Screen("dashboardScreen")
    object  HomeScreen : Screen("homeScreen")
    object  SettingScreen : Screen("settingScreen")
    object  HelpScreen : Screen("helpScreen")


    fun withArgs(vararg args: String) : String{
        return  buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}
