package com.cs.navigationdrawerbottomsheetcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cs.jetpacknavigationdrawer.AppBar
import com.cs.jetpacknavigationdrawer.NavigationDrawer
import com.cs.navigationdrawerbottomsheetcompose.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var text = remember {
        mutableStateOf("")
    }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(scaffoldState = scaffoldState, scope = scope, title = "Dashboard")
        },
        drawerContent = {
            NavigationDrawer(navController = navController)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Dashboard View",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )

            TextField(value = text.value, onValueChange ={
                text.value = it
            } )
            Button(onClick = {
                navController.navigate(Screen.HomeScreen.withArgs(text.value))
            }) {

            }
        }

    }

}