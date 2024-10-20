package com.example.architecturepatternsinandroid.presentation.mvi

//user intentions (user actions)
sealed class MovieIntent{
    object FetchMovies: MovieIntent()
    object GoBack: MovieIntent()
}