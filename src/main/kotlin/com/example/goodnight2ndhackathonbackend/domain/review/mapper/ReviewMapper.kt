package com.example.goodnight2ndhackathonbackend.domain.review.mapper

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import com.example.goodnight2ndhackathonbackend.domain.review.dto.ReviewCreateRequest
import org.springframework.stereotype.Component

@Component
class ReviewMapper {

    fun mapCreateReviewToEntity(movie: Movie, reviewCreateRequest: ReviewCreateRequest): Review {
        return Review(
                movie = movie,
                rating = reviewCreateRequest.rating,
                content = reviewCreateRequest.content
        )
    }

    fun mapReviewEntityToReviewInfo(review: Review): Review {
        return Review(
                movie = review.movie,
                rating = review.rating,
                content = review.content
        )
    }
}