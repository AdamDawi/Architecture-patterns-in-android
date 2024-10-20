package com.example.architecturepatternsinandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.architecturepatternsinandroid.presentation.nav.Navigation
import com.example.architecturepatternsinandroid.presentation.theme.ArchitecturePatternsInAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitecturePatternsInAndroidTheme {
                Navigation()
            }
        }
    }
}