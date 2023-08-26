package com.example.goodnight2ndhackathonbackend.domain.review.dto

data class ReviewOptionRequest (
        val movieId: Long,
        val minRating: Double? = null
)