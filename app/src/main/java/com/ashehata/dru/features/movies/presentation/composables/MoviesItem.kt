package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ashehata.dru.R
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel

@Composable
fun MoviesItem(movie: MovieUIModel) {

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        TitleWithDescriptionItem(
            titleRes = R.string.name,
            description = movie.title ?: ""
        )

        TitleWithDescriptionItem(
            titleRes = R.string.vote_average,
            description = movie.voteAverage.toString()
        )
    }
}