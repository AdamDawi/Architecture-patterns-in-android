package com.example.architecturepatternsinandroid.presentation.mvi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturepatternsinandroid.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MviViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MovieViewState())
    val state: StateFlow<MovieViewState> = _state

    //or name it like: onEvent or onAction
    fun handleIntent(intent: MovieIntent) {
        when (intent) {
            is MovieIntent.FetchMovies -> fetchMovies()
            else -> Unit
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            //Important that you copy value of state
            _state.value = _state.value.copy(loading = true)
            try {
                val movies = movieRepository.getMovies()
                _state.value = _state.value.copy(loading = false, movies = movies)
            } catch (e: Exception) {
                Log.e("MviViewModel", "Error fetching movies: ${e.message}")
                _state.value = _state.value.copy(loading = false, error = e.message)
            }
        }
    }
}