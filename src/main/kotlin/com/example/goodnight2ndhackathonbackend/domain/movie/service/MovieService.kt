package com.example.goodnight2ndhackathonbackend.domain.movie.service

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository.MovieRepository
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.*
import com.example.goodnight2ndhackathonbackend.domain.movie.mapper.MovieMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
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

    fun findMoviesWithAvgRatings(page: Int, size: Int): Page<MovieWithAvgRatingProjection> {
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "avgRating"))
        return movieRepository.findAllWithAvgRatings(pageable)
    }

}