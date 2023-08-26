package com.example.goodnight2ndhackathonbackend.domain.review.domain.repository

import com.example.goodnight2ndhackathonbackend.domain.review.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {

}