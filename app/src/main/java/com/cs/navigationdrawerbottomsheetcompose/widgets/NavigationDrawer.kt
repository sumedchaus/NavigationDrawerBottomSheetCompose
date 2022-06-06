package com.cs.jetpacknavigationdrawer

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cs.jetpacknavigationdrawer.model.MenuItems
import com.cs.navigationdrawerbottomsheetcompose.navigation.Screen

@Composable
fun NavigationDrawer(navController: NavController) {
    val context = LocalContext.current

    DrawerHeader()
    DrawerBody(items = listOf(
        MenuItems(
            id = "dashboard",
            title = "Dashboard",
            contentDescription = "Go to Dashboard Screen",
            icon = Icons.Default.Menu
        ),
        MenuItems(
            id = "home",
            title = "Home",
            contentDescription = "Go to Home Screen",
            icon = Icons.Default.Home
        ),
        MenuItems(
            id = "setting",
            title = "Setting",
            contentDescription = "Go to setting Screen",
            icon = Icons.Default.Settings
        ),
        MenuItems(
            id = "help",
            title = "Help",
            contentDescription = "Get Help",
            icon = Icons.Default.Info
        ),

        ), onItemClick = { item ->

        when(item.id){
            "dashboard" -> navController.navigate(Screen.DashboardScreen.route)
            "home" -> navController.navigate(Screen.HomeScreen.route)
            "setting" -> navController.navigate(Screen.SettingScreen.route)
            "help" -> navController.navigate(Screen.HelpScreen.route)
        }

        Toast.makeText(context, "${item.title} clicked", Toast.LENGTH_SHORT).show()


    })

}


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItems>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItems) -> Unit
) {

    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = modifier.weight(1f)
                )

            }

        }
    }

}