package com.example.goodnight2ndhackathonbackend.domain.review.dto

data class ReviewCreateRequest(
        val movieId: Long,
        val rating: Double,
        val content: String,
)