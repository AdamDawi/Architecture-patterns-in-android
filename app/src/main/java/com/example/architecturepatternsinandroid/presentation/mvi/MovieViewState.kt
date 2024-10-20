package com.example.architecturepatternsinandroid.presentation.mvi

import com.example.architecturepatternsinandroid.domain.model.Movie

//if using xml single field change trigger whole flow collector
//on compose it is smart enough to detect which fields actually changed (exception: unstable field like normal list)
data class MovieViewState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)