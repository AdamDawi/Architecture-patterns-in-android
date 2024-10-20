package com.example.architecturepatternsinandroid.presentation.mvi

import com.example.architecturepatternsinandroid.domain.model.Movie

data class MovieViewState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)