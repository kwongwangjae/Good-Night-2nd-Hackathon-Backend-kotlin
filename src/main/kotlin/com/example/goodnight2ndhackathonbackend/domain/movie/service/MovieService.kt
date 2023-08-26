package com.example.goodnight2ndhackathonbackend.domain.movie.service

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository.MovieRepository
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieInfo
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieOptionRequest
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieUpdateRequest
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
    fun findMovieId(id: Long): MovieInfo {
        val findMovie = movieRepository.findById(id)
                .orElseThrow { IllegalArgumentException("해당하는 영화가 없습니다. ID: $id") }
        return movieMapper.mapMovieEntityToMovieInfo(findMovie)
    }

    fun getMoviesByOptions(movieOptionRequest: MovieOptionRequest): List<Movie> {
        return movieRepository.findByOptions(
                movieOptionRequest.genre,
                movieOptionRequest.showing
        )
    }


    fun deleteMovie(id: Long): MovieInfo {
        val findMovie = movieRepository.findById(id)
                .orElseThrow { IllegalArgumentException("해당하는 영화가 없습니다. ID: $id") }
        findMovie.isDeleted = true
        val deletedMovie = movieRepository.save(findMovie)
        return movieMapper.mapMovieEntityToMovieInfo(deletedMovie)
    }

    fun updateMovie(movieUpdateRequest: MovieUpdateRequest): MovieInfo {
        val findMovie = movieRepository.findById(movieUpdateRequest.id)
                .orElseThrow { IllegalArgumentException("해당하는 영화가 없습니다. ID: ${movieUpdateRequest.id}") }
        findMovie.updateMovie(movieUpdateRequest)
        val updatedMovie = movieRepository.save(findMovie)
        return movieMapper.mapMovieEntityToMovieInfo(updatedMovie)
    }

}