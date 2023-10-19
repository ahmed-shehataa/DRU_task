package com.ashehata.dru.features.movies.data.remote

import com.ashehata.dru.features.movies.data.model.MovieDataModel
import com.ashehata.dru.features.movies.data.retrofit.service.MoviesService
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val service: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun getMovies(): List<MovieDataModel> {
        return service.getMovies().movies ?: emptyList()
    }
}