package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashehata.dru.R
import com.ashehata.dru.common.models.NetworkError
import com.ashehata.dru.common.presentation.compose.NetworkErrorUI
import com.ashehata.dru.common.presentation.compose.ProgressLoading
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreenContent(
    moviesList: List<MovieUIModel>,
    isLoading: Boolean,
    isRefreshing: Boolean,
    isRefreshState: PullRefreshState,
    networkError: NetworkError?,
    onMovieClicked: (MovieUIModel) -> Unit,
    onTryAgain: () -> Unit,
) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.movies_title),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                })
        }) { scaffold ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = scaffold.calculateTopPadding(),
                    bottom = scaffold.calculateBottomPadding(),
                )
                .pullRefresh(isRefreshState)

        ) {

            if (isLoading) {
                ProgressLoading()
            } else if (networkError != null) {
                NetworkErrorUI(networkError = networkError, onTryClicked = onTryAgain)
            } else
                MoviesList(moviesList, onMovieClicked)

            PullRefreshIndicator(
                refreshing = isRefreshing, state = isRefreshState, modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )
        }
    }

}