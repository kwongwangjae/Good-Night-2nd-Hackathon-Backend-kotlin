package com.example.goodnight2ndhackathonbackend.domain.movie.dto

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie

interface MovieWithAvgRatingProjection {
    fun getMovie(): Movie
    fun getAvgRating(): Double?
}