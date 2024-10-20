package com.example.architecturepatternsinandroid.domain.repository

import com.example.architecturepatternsinandroid.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}