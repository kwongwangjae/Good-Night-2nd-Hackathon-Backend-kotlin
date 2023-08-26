package com.example.goodnight2ndhackathonbackend.domain.movie.dto

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.MovieGenre
import java.time.LocalDate

data class MovieInfo(
        val id: Long?,
        val title: String,
        val genre: MovieGenre,
        val releaseDate: LocalDate,
        val endDate: LocalDate,
        val showing: Boolean
)
