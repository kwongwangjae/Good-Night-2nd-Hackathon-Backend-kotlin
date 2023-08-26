package com.example.goodnight2ndhackathonbackend.domain.review.controller

import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import com.example.goodnight2ndhackathonbackend.domain.review.dto.ReviewCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.review.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ReviewController(
        private val reviewService: ReviewService
) {

    @PostMapping("/reviews")
    fun createReview(@RequestBody request: ReviewCreateRequest): ResponseEntity<Review> {
        val createdReview = reviewService.createReview(request)
        return ResponseEntity.ok(createdReview)
    }
}