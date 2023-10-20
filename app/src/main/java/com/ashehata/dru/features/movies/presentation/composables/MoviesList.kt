package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesList(moviesList: List<MovieUIModel>, onMovieClicked: (MovieUIModel) -> Unit) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) { moviesList.size }
    val isScrollToStartVisible = remember {
        derivedStateOf {
            pagerState.currentPage > 0
        }
    }
    val isScrollToEndVisible = remember {
        derivedStateOf {
            pagerState.currentPage < pagerState.pageCount - 1
        }
    }


    Box {
        HorizontalPager(
            state = pagerState, contentPadding = PaddingValues(all = 16.dp), pageSpacing = 12.dp
        ) {
            MoviesItem(
                modifier = Modifier.fillMaxSize(),
                movie = moviesList[it],
                isSelected = it == pagerState.currentPage,
                onMovieClicked = onMovieClicked
            )
        }

        ScrollButton(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterStart),
            isVisible = isScrollToStartVisible.value,
            icon = Icons.Default.ArrowBack,
            onClicked = {
                scope.launch {
                    pagerState.animateScrollToPage(0)
                }
            },
        )


        ScrollButton(
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterEnd),
            isVisible = isScrollToEndVisible.value,
            icon = Icons.Default.ArrowForward,
            onClicked = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.pageCount - 1)
                }
            },
        )

    }

}