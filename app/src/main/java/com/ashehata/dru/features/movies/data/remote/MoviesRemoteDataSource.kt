package com.ashehata.dru.features.movies.data.remote

import com.ashehata.dru.features.movies.data.model.MovieDataModel

interface MoviesRemoteDataSource {

    suspend fun getMovies(): List<MovieDataModel>
}