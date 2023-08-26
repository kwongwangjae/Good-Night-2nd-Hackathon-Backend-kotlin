package com.example.goodnight2ndhackathonbackend.domain.movie.service

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository.MovieRepository
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieInfo
import com.example.goodnight2ndhackathonbackend.domain.movie.mapper.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieService(
        private val movieRepository: MovieRepository,
        private val movieMapper: MovieMapper
) {
    fun createMovie(movieCreateRequest: MovieCreateRequest): MovieInfo{
        val newMovie = movieMapper.mapCreateMovieToEntity(movieCreateRequest)
        val savedMovie = movieRepository.save(newMovie)
        return movieMapper.mapMovieEntityToMovieInfo(savedMovie)
    }
}