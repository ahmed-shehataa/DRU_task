package com.ashehata.dru.features.movies.data.local.source

import com.ashehata.dru.features.movies.data.model.MovieDataModel

interface MoviesLocalDataSource {

    suspend fun getMovies(): List<MovieDataModel>

    suspend fun insert(movies: List<MovieDataModel>)

    suspend fun clearAll()

}