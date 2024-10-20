package com.example.architecturepatternsinandroid.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.architecturepatternsinandroid.presentation.mvi.MviScreen
import com.example.architecturepatternsinandroid.presentation.mvvm.MvvmScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Mvi.route) {
            MviScreen(
                goBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = Screen.Mvvm.route) {
            MvvmScreen(
                goBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}