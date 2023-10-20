package com.ashehata.dru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashehata.dru.features.movieDetails.presentation.compoasbales.MovieDetailsScreen
import com.ashehata.dru.features.movies.presentation.composables.MoviesScreen
import com.ashehata.dru.features.movies.presentation.model.MovieUIModel
import com.ashehata.dru.theme.AppTheme
import com.ashehata.dru.util.parcelable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTheme {
                NavHost(navController = navController, startDestination = "movies") {
                    composable("movies") {
                        MoviesScreen(navController = navController)
                    }

                    composable("movie_details") {
                        val movie = it.arguments?.parcelable<MovieUIModel>("movie")
                        movie?.let {
                            MovieDetailsScreen(movie = movie, navController = navController)
                        }
                    }
                }
            }
        }
    }
}