package com.example.architecturepatternsinandroid.presentation.mvvm

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.architecturepatternsinandroid.domain.model.Movie
import com.example.architecturepatternsinandroid.presentation.components.CustomTopAppBar
import com.example.architecturepatternsinandroid.presentation.components.MoviesList

@Composable
fun MvvmScreen(
    viewModel: MvvmViewModel = hiltViewModel(),
    goBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.fetchMovies()
    }
    MvvmScreenContent(
        movies = viewModel.movies.collectAsState().value,
        error = viewModel.error.collectAsState().value,
        isLoading = viewModel.isLoading.collectAsState().value,
        goBack = goBack
    )
}

@Composable
fun MvvmScreenContent(
    movies: List<Movie>,
    error: String?,
    isLoading: Boolean,
    goBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = "MVVM",
                onAction = goBack
            )
        },
        containerColor = Color.White
    ) { scaffoldPadding ->
        when {
            isLoading -> {
                // Display a loading indicator
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPadding.calculateTopPadding()),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
                }
            }

            error != null -> {
                // Display an error message
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPadding.calculateTopPadding()),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Center
                ) {

                    Text(text = "Error: $error", color = Color.Red)
                }
            }

            else -> {
                // Display the list of movies
                MoviesList(
                    modifier = Modifier.padding(scaffoldPadding),
                    movies = movies
                )
            }
        }
    }
}