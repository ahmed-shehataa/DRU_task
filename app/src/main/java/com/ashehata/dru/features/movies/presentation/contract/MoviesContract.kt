package com.ashehata.dru.features.movies.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ashehata.dru.common.models.NetworkError
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel


data class MoviesUiState(
    val isLoading: MutableState<Boolean> = mutableStateOf(true),
    val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    val networkError: MutableState<NetworkError?> = mutableStateOf(null),
    val moviesList: SnapshotStateList<MovieUIModel> = mutableStateListOf(),
)

sealed class MovieUiIntent {
    object RefreshScreen : MovieUiIntent()
}


