package com.example.architecturepatternsinandroid.data.repository

import com.example.architecturepatternsinandroid.data.remote.FakeDataApi
import com.example.architecturepatternsinandroid.domain.model.Movie
import com.example.architecturepatternsinandroid.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val fakeDataApi: FakeDataApi
): MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return fakeDataApi.getMovies()
    }
}