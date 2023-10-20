package com.ashehata.dru.features.movies.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashehata.dru.features.movies.domain.usecase.GetMoviesListUseCase
import com.ashehata.dru.features.movies.presentation.contract.MovieUiIntent
import com.ashehata.dru.features.movies.presentation.contract.MoviesUiState
import com.ashehata.dru.features.movies.presentation.mapper.toUIModel
import com.ashehata.dru.util.toNetworkError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesListUseCase: GetMoviesListUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MoviesUiState> = MutableStateFlow(MoviesUiState())
    val uiState: StateFlow<MoviesUiState> = _uiState

    private val _uiIntent: MutableSharedFlow<MovieUiIntent> = MutableSharedFlow()

    private val moviesHandlerException =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.i("moviesHandlerException: ", "done")
            _uiState.value.isLoading.value = false
            _uiState.value.networkError.value = throwable.toNetworkError()
        }


    init {
        handleIntents()
        getMovies()
    }

    private fun handleIntents() {
        viewModelScope.launch {
            _uiIntent.collectLatest {
                Log.i("handleIntents", "_uiIntent:")
                when (it) {
                    MovieUiIntent.RefreshScreen -> {
                        // refresh screen now
                        Log.i("handleIntents", "handleIntents:")
                        resetUiStates()
                        getMovies()
                    }
                }
            }
        }
    }

    private fun resetUiStates() {
        _uiState.value.moviesList.clear()
        _uiState.value.networkError.value = null
        _uiState.value.isLoading.value = true
    }

    private fun getMovies() {
        viewModelScope.launch(moviesHandlerException) {
            _uiState.value.isLoading.value = true
            val movies = getMoviesListUseCase.execute().map { it.toUIModel() }
            _uiState.value.isLoading.value = false
            _uiState.value.moviesList.addAll(movies)
        }
    }

    fun setIntent(uiIntent: MovieUiIntent) {
        viewModelScope.launch {
            _uiIntent.emit(uiIntent)
        }

    }
}