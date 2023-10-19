package com.ashehata.dru.features.movies.presentation.model

import com.ashehata.dru.BuildConfig

data class MovieUIModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int?>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val posterUrl: String = BuildConfig.BASE_IMAGE_URL + "w500/" + posterPath,
    val voteRate: VoteRate = VoteRate.getRate(voteAverage ?: 0.0)
)