package com.example.architecturepatternsinandroid.presentation.mvi

sealed class MovieIntent{
    object FetchMovies: MovieIntent()
}