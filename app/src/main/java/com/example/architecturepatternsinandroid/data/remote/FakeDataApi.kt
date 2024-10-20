package com.example.architecturepatternsinandroid.data.remote

import com.example.architecturepatternsinandroid.domain.model.Movie
import kotlinx.coroutines.delay

class FakeDataApi {
    suspend fun getMovies(): List<Movie> {
        delay(2000L)
        return listOf(
            Movie(1, "Spiderman", "2020"),
            Movie(2, "Captain America", "2013"),
            Movie(3, "Black Panther", "2021"),
            Movie(4, "Iron Man", "2016"),
            Movie(5, "Avengers", "2024"),
            Movie(6, "Spiderman", "2020"),
            Movie(7, "Captain America", "2013"),
            Movie(8, "Black Panther", "2021"),
            Movie(9, "Iron Man", "2016"),
            Movie(10, "Avengers", "2024"),
            Movie(11, "Spiderman", "2020"),
            Movie(12, "Captain America", "2013"),
            Movie(13, "Black Panther", "2021"),
            Movie(14, "Iron Man", "2016"),
            Movie(15, "Avengers", "2024"),
            Movie(16, "Spiderman", "2020"),
            Movie(17, "Captain America", "2013"),
            Movie(18, "Black Panther", "2021"),
            Movie(19, "Iron Man", "2016"),
            Movie(20, "Avengers", "2024")
        )
    }
}