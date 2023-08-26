package com.example.goodnight2ndhackathonbackend.domain.movie.dto

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.MovieGenre

data class MovieOptionRequest(
        var genre: MovieGenre? = null,
        var showing: Boolean? = null
)