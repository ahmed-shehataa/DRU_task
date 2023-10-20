package com.ashehata.dru.features.movieDetails.presentation.compoasbales

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel


@Composable
fun MovieDetailsScreen(movie: MovieUIModel, navController: NavController) {

    MovieDetailsScreenContent(movie = movie) {
        navController.navigateUp()
    }
}