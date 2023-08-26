package com.example.goodnight2ndhackathonbackend.domain.movie.mapper

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieCreateRequest
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieInfo
import org.springframework.stereotype.Component

@Component
class MovieMapper {

    fun mapCreateMovieToEntity(movieCreateRequest: MovieCreateRequest): Movie {
        return Movie(
                title = movieCreateRequest.title,
                genre = movieCreateRequest.genre,
                releaseDate = movieCreateRequest.releaseDate,
                endDate = movieCreateRequest.endDate,
                showing = movieCreateRequest.showing
        )
    }

    fun mapMovieEntityToMovieInfo(movie: Movie): MovieInfo {
        return MovieInfo(
                id = movie.id,
                title = movie.title,
                genre = movie.genre,
                releaseDate = movie.releaseDate,
                endDate = movie.endDate,
                showing = movie.showing
        )
    }
}
