package com.example.architecturepatternsinandroid.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.architecturepatternsinandroid.domain.model.Movie

@Composable
fun MoviesList(
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        items(movies) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .shadow(4.dp, RoundedCornerShape(8.dp))
            ) {
                Text(
                    text = "Movie: ${movie.title}",
                    modifier = Modifier
                        .padding(4.dp)
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = "Date: ${movie.year}",
                    modifier = Modifier
                        .padding(4.dp)
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}