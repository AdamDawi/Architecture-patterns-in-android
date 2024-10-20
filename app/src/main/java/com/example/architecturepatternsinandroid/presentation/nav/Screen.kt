package com.example.architecturepatternsinandroid.presentation.nav

sealed class Screen(val route: String) {
    data object Main: Screen("main_screen")
    data object Mvi: Screen("mvi_screen")
    data object Mvvm: Screen("mvvm_screen")
    data object Mvp: Screen("mvp_screen")
    data object Mvc: Screen("mvc_screen")
}