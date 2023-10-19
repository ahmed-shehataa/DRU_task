package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel

@Composable
fun MoviesList(moviesList: List<MovieUIModel>) {

    LazyColumn {

        items(moviesList) {
            MoviesItem(it)
        }
    }

}