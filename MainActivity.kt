package com.anurup.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anurup.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainScreen (onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "about",
                                    title = "About US",
                                    contentDescription = "Go to about_us",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "administration",
                                    title = "Administration",
                                    contentDescription = "Go to administration",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "academics",
                                    title = "Academics",
                                    contentDescription = "Go to academics",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "support",
                                    title = "Student Support",
                                    contentDescription = "Go to student_support",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "trainings",
                                    title = "Trainings & Placements",
                                    contentDescription = "Go to trainings",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "gallery",
                                    title = "Gallery",
                                    contentDescription = "Go to gallery",
                                    icon = Icons.Default.Info
                                ),
                                MenuItem(
                                    id = "contact",
                                    title = "Contact Us",
                                    contentDescription = "Go to contact_us",
                                    icon = Icons.Default.Info
                                ),
                            ),
                            onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                    }
                ) {

                }
            }
        }
    }
}