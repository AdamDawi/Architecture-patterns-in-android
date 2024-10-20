package com.example.architecturepatternsinandroid.data.remote

import com.example.architecturepatternsinandroid.domain.model.Movie

class FakeDataApi {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie(1, "Spiderman", "2020"),
            Movie(2, "Captain America", "2013"),
            Movie(3, "Black Panther", "2021"),
            Movie(4, "Iron Man", "2016"),
            Movie(5, "Avengers", "2024")

        )
    }
}