package com.example.architecturepatternsinandroid.presentation.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturepatternsinandroid.domain.model.Movie
import com.example.architecturepatternsinandroid.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MvvmViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun fetchMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val movies = movieRepository.getMovies()
                _isLoading.value = false
                _movies.value = movies
            } catch (e: Exception) {
                Log.e("MvvmViewModel", "Error fetching movies: ${e.message}")
                _isLoading.value = false
                _error.value = e.message
            }
        }
    }
}