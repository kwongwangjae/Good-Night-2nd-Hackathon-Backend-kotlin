package com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
}