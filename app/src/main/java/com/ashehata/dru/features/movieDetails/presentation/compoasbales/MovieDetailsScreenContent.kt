package com.ashehata.dru.features.movieDetails.presentation.compoasbales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ashehata.dru.R
import com.ashehata.dru.common.presentation.compose.VoteBadge
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel


@Composable
fun MovieDetailsScreenContent(
    movie: MovieUIModel,
    onBackClicked: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LazyColumn {
            item {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop,
                    model = movie.backdropUrl,
                    contentDescription = null,
                )
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }

            item {
                movie.title?.let {
                    TitleWithDescriptionItem(
                        titleRes = R.string.name,
                        description = movie.title
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }

            item {
                movie.overview?.let {
                    TitleWithDescriptionItem(
                        titleRes = R.string.overview,
                        description = movie.overview
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }

            item {
                movie.releaseDate?.let {
                    TitleWithDescriptionItem(
                        titleRes = R.string.releaseDate,
                        description = movie.releaseDate
                    )
                }
            }
        }

        BackButton(
            onBackClicked,
            Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(start = 12.dp, top = 12.dp)

        )

        VoteBadge(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(end = 12.dp, top = 12.dp), movie = movie

        )
    }

}