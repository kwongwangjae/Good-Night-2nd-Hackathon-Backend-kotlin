package com.example.goodnight2ndhackathonbackend.domain.review.dto

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie

data class ReviewInfo(
        val movie: Movie,
        val rating: Double,
        val content: String,
)