package com.ashehata.dru.features.movies.data.repository

import com.ashehata.dru.features.movies.data.local.source.MoviesLocalDataSource
import com.ashehata.dru.features.movies.data.mapper.toDomainModel
import com.ashehata.dru.features.movies.data.remote.MoviesRemoteDataSource
import com.ashehata.dru.features.movies.domain.model.MovieDomainModel
import com.ashehata.dru.features.movies.domain.repository.MovesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MoviesRepositoryImpl @Inject constructor(
    private val remote: MoviesRemoteDataSource,
    private val local: MoviesLocalDataSource,
) : MovesRepository {


    override suspend fun getMovies(): List<MovieDomainModel> = withContext(Dispatchers.IO) {
        return@withContext local.getMovies().map { it.toDomainModel() }
    }


}