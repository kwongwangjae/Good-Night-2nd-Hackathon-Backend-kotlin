package com.example.goodnight2ndhackathonbackend.domain.review.controller

import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import com.example.goodnight2ndhackathonbackend.domain.review.dto.ReviewCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.review.dto.ReviewOptionRequest
import com.example.goodnight2ndhackathonbackend.domain.review.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/reviews")
    fun getReviews(@ModelAttribute request: ReviewOptionRequest): ResponseEntity<List<Review>> {
        val reviews = reviewService.getReviews(request)
        return ResponseEntity.ok(reviews)
    }
}