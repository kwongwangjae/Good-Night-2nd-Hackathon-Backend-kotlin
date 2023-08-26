package com.example.goodnight2ndhackathonbackend.domain.review.domain.repository

import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ReviewRepository : JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.movie.id = :movieId AND (:minRating IS NULL OR r.rating >= :minRating) ORDER BY r.createdAt DESC")
    fun findByMovieIdAndMinRating(
            @Param("movieId") movieId: Long,
            @Param("minRating") minRating: Double?
    ): List<Review>

}