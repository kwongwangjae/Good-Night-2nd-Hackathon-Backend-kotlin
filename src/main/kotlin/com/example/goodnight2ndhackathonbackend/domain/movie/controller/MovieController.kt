package com.example.goodnight2ndhackathonbackend.domain.movie.controller

import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieInfo
import com.example.goodnight2ndhackathonbackend.domain.movie.service.MovieService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class MovieController(
        private val movieService: MovieService
) {
    @PostMapping("/movies")
    fun createMovie(@RequestBody movieCreateRequest: MovieCreateRequest): MovieInfo{
        return movieService.createMovie(movieCreateRequest)
    }

}