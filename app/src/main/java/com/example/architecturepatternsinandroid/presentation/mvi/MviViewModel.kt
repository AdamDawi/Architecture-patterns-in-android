package com.example.architecturepatternsinandroid.presentation.mvi

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
): ViewModel() {
    private val _state = MutableStateFlow(MovieViewState())
    val state: StateFlow<MovieViewState> = _state

    fun handleIntent(intent: MovieIntent){
        when(intent){
            is MovieIntent.FetchMovies -> fetchMovies()
        }
    }

    private fun fetchMovies(){
        viewModelScope.launch{
            _state.value = _state.value.copy(loading = true)
            try {
                val movies = movieRepository.getMovies()
                _state.value = _state.value.copy(loading = false, movies = movies)
            }catch (e: Exception){
                _state.value = _state.value.copy(loading = false, error = e.message)
            }
        }
    }
}