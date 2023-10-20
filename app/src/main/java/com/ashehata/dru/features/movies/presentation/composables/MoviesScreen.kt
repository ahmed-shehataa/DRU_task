package com.ashehata.dru.features.movies.presentation.composables

import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashehata.dru.features.movies.presentation.contract.MovieUiIntent
import com.ashehata.dru.features.movies.presentation.viewmodel.MoviesViewModel
import com.ashehata.dru.util.navigate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    navController: NavController
) {

    val uiState = viewModel.uiState.collectAsState().value

    val isLoading = remember {
        uiState.isLoading
    }

    val isRefreshing = remember {
        uiState.isRefreshing
    }

    val networkError = remember {
        uiState.networkError
    }

    val moviesList = remember {
        uiState.moviesList
    }

    val onRefresh = remember {
        {
            viewModel.setIntent(MovieUiIntent.RefreshScreen)
        }
    }

    val isRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing.value,
        onRefresh = onRefresh
    )

    MoviesScreenContent(
        isLoading = isLoading.value,
        isRefreshing = isRefreshing.value,
        isRefreshState = isRefreshState,
        moviesList = moviesList,
        networkError = networkError.value,
        onTryAgain = {
            onRefresh()
        },
        onMovieClicked = {
            navController.navigate(route = "movie_details", args = Bundle().apply {
                putParcelable("movie", it)
            })
        }
    )


}