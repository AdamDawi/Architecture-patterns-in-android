package com.example.architecturepatternsinandroid.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.architecturepatternsinandroid.presentation.mvi.MviScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ){
        composable(route = Screen.Main.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.Mvi.route){
            MviScreen()
        }
    }
}