package com.example.goodnight2ndhackathonbackend.domain.review.service

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository.MovieRepository
import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import com.example.goodnight2ndhackathonbackend.domain.review.domain.repository.ReviewRepository
import com.example.goodnight2ndhackathonbackend.domain.review.dto.ReviewCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.review.mapper.ReviewMapper
import org.springframework.stereotype.Service

@Service
class ReviewService(
        private val reviewRepository: ReviewRepository,
        private val movieRepository: MovieRepository,
        private val reviewMapper: ReviewMapper
) {
    fun createReview(reviewCreateRequest: ReviewCreateRequest): Review {
        val movie: Movie = movieRepository.findById(reviewCreateRequest.movieId)
                .orElseThrow { IllegalArgumentException("영화의 아이디를 찾을 수 없습니다.") }

        val newReview = reviewMapper.mapCreateReviewToEntity(movie, reviewCreateRequest)
        return reviewRepository.save(newReview)
    }
}