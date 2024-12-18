package com.example.architecturepatternsinandroid.presentation.mvi

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.architecturepatternsinandroid.domain.model.Movie
import com.example.architecturepatternsinandroid.presentation.components.CustomTopAppBar
import com.example.architecturepatternsinandroid.presentation.components.MoviesList
import com.example.architecturepatternsinandroid.presentation.theme.ArchitecturePatternsInAndroidTheme

@Composable
fun MviScreen(
    viewModel: MviViewModel = hiltViewModel(),
    goBack: () -> Unit
) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(MovieIntent.FetchMovies)
    }
    MviScreenContent(
        onAction = { action ->
            when (action) {
                is MovieIntent.GoBack -> {
                    goBack()
                }

                else -> Unit
            }
            viewModel.handleIntent(action)
        },
        state = state.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MviScreenContent(
    onAction: (MovieIntent) -> Unit,
    state: MovieViewState
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = "MVI",
                onAction = { onAction(MovieIntent.GoBack) }
            )
        },
        containerColor = Color.White
    ) { scaffoldPadding ->
        when {
            state.loading -> {
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

            state.error != null -> {
                // Display an error message
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(scaffoldPadding.calculateTopPadding()),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Center
                ) {

                    Text(text = "Error: ${state.error}", color = Color.Red)
                }
            }

            else -> {
                // Display the list of movies
                MoviesList(
                    modifier = Modifier.padding(scaffoldPadding),
                    movies = state.movies
                )
            }
        }
    }
}


@Preview
@Composable
private fun MoviesListPreview() {
    ArchitecturePatternsInAndroidTheme {
        MoviesList(
            movies = listOf(
                Movie(1, "Spiderman", "2020"),
                Movie(2, "Captain America", "2013"),
                Movie(3, "Black Panther", "2021"),
            )
        )
    }
}