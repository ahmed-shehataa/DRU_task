package com.ashehata.dru.features.movies.data.mapper

import com.ashehata.dru.features.movies.data.model.MovieDataModel
import com.ashehata.dru.features.movies.domain.model.MovieDomainModel

fun MovieDataModel.toDomainModel() = MovieDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)