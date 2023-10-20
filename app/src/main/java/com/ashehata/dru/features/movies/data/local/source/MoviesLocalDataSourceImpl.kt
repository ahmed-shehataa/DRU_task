package com.ashehata.dru.features.movies.data.local.source

import com.ashehata.dru.features.movies.data.local.dao.MoviesDao
import com.ashehata.dru.features.movies.data.model.MovieDataModel
import javax.inject.Inject

class MoviesLocalDataSourceImpl @Inject constructor(
    private val dao: MoviesDao
) : MoviesLocalDataSource {
    override suspend fun getMovies(): List<MovieDataModel> {
        return dao.getMovies()
    }

    override suspend fun insert(movies: List<MovieDataModel>) {
        dao.insertAll(movies)
    }

    override suspend fun clearAll() {
        dao.deleteAll()
    }


}