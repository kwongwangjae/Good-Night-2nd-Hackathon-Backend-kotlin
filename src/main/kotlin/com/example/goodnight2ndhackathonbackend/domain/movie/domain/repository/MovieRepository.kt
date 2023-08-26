package com.example.goodnight2ndhackathonbackend.domain.movie.domain.repository

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.MovieGenre
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieWithAvgRatingProjection
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface MovieRepository : JpaRepository<Movie, Long> {
    @Query(
            "SELECT m FROM Movie m WHERE (:genre IS NULL OR m.genre = :genre) AND (:isShowing IS NULL OR m.showing = :isShowing) ORDER BY m.releaseDate ASC"
    )
    fun findByOptions(@Param("genre") genre: MovieGenre?, @Param("isShowing") isShowing: Boolean?): List<Movie>

    @Query("SELECT m as movie, AVG(r.rating) as avgRating FROM Movie m LEFT JOIN m.reviews r GROUP BY m.id ORDER BY avgRating DESC")
    fun findAllWithAvgRatings(pageable: Pageable): Page<MovieWithAvgRatingProjection>


}