package com.cs.navigationdrawerbottomsheetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cs.navigationdrawerbottomsheetcompose.navigation.Navigation
import com.cs.navigationdrawerbottomsheetcompose.ui.theme.NavigationDrawerBottomSheetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerBottomSheetComposeTheme {
                Navigation()
            }
        }
    }
}
