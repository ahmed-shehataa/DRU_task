package com.ashehata.dru.features.movies.di

import com.ashehata.dru.features.movies.data.local.source.MoviesLocalDataSource
import com.ashehata.dru.features.movies.data.local.source.MoviesLocalDataSourceImpl
import com.ashehata.dru.features.movies.data.remote.MoviesRemoteDataSource
import com.ashehata.dru.features.movies.data.remote.MoviesRemoteDataSourceImpl
import com.ashehata.dru.features.movies.data.repository.MoviesRepositoryImpl
import com.ashehata.dru.features.movies.data.retrofit.service.MoviesService
import com.ashehata.dru.features.movies.domain.repository.MovesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class MoviesModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMoviesRemoteDataSource(moviesRemoteDataSourceImpl: MoviesRemoteDataSourceImpl): MoviesRemoteDataSource


    @Binds
    @ViewModelScoped
    abstract fun bindMoviesLocalDataSource(moviesLocalDataSourceImpl: MoviesLocalDataSourceImpl): MoviesLocalDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindMoviesRepository(moviesRepoImpl: MoviesRepositoryImpl): MovesRepository


    companion object {
        @ViewModelScoped
        @Provides
        fun provideMoviesService(retrofit: Retrofit): MoviesService =
            retrofit.create(MoviesService::class.java)

    }
}