package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel
import com.ashehata.dru.features.movies.presentation.model.VoteRate

@Composable
fun MoviesItem(modifier: Modifier, movie: MovieUIModel, isSelected: Boolean) {

    val scaleAnimated = animateFloatAsState(targetValue = if (isSelected) 1f else .9f)

    Box(
        modifier = modifier
            .scale(scaleAnimated.value)
            .clip(MaterialTheme.shapes.large)
            .clickable {

            }
            .background(Color.LightGray),
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = movie.posterUrl,
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = .5f))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = movie.title ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = Color.White,
                )
            )
            Text(
                text = movie.releaseDate ?: "",
                fontSize = 18.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        VoteBadge(
            Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp), movie
        )

    }

}

@Composable
fun VoteBadge(
    modifier: Modifier,
    movie: MovieUIModel
) {

    val color = remember {
        when (movie.voteRate) {
            VoteRate.HIGH -> Color.Red
            VoteRate.MEDIUM -> Color.Blue
            VoteRate.LOW -> Color.Green
            VoteRate.UNKNOWN -> Color.Gray
        }
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .padding(8.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = (movie.voteAverage ?: 0).toString(),
            fontSize = 18.sp,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}
