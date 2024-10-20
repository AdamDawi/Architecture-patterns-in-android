package com.example.architecturepatternsinandroid.presentation.nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Architecture Patterns in Android",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .height(64.dp)
                    .fillMaxWidth(),
                onClick = {
                }
            ) {
                Text(
                    text = "MVVM",
                    color = Color.Black
                )
            }
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .height(64.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(Screen.Mvi.route)
                }
            ) {
                Text(
                    text = "MVI",
                    color = Color.Black
                )
            }
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .height(64.dp)
                    .fillMaxWidth(),
                onClick = {
                }
            ) {
                Text(
                    text = "MVP",
                    color = Color.Black
                )
            }
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .height(64.dp)
                    .fillMaxWidth(),
                onClick = {
                }
            ) {
                Text(
                    text = "MVC",
                    color = Color.Black
                )
            }

        }

    }
}