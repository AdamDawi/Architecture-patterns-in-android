package com.example.architecturepatternsinandroid.presentation.mvi

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.architecturepatternsinandroid.domain.model.Movie

@Composable
fun MviScreen(
    viewModel: MviViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(MovieIntent.FetchMovies)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        when {
            state.value.loading -> {
                // Display a loading indicator
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
                }
            }

            state.value.error != null -> {
                // Display an error message
                Text(text = "Error: ${state.value.error}", color = Color.Red)
            }

            else -> {
                // Display the list of movies
                Text(
                    text = "MVI",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                MoviesList(movies = state.value.movies)
            }
        }
    }
}

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .shadow(4.dp, RoundedCornerShape(8.dp))
            ) {
                Text(text = "Movie: ${movie.title}",
                    modifier = Modifier
                        .padding(4.dp)
                        .padding(horizontal = 8.dp)
                )
                Text(text = "Date: ${movie.year}",
                    modifier = Modifier
                        .padding(4.dp)
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}