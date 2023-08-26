package com.example.goodnight2ndhackathonbackend.domain.movie.controller

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.domain.movie.dto.*
import com.example.goodnight2ndhackathonbackend.domain.movie.service.MovieService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1")
class MovieController(
        private val movieService: MovieService
) {
    @PostMapping("/movies")
    fun createMovie(@RequestBody movieCreateRequest: MovieCreateRequest): MovieInfo{
        return movieService.createMovie(movieCreateRequest)
    }

    @GetMapping("/movies/{id}")
    fun getMovie(@PathVariable("id") id: Long): ResponseEntity<MovieInfo> {
        val movieInfo = movieService.findMovieId(id)
        return ResponseEntity.ok(movieInfo)
    }

    @GetMapping("/movies")
    fun getMovies(movieOptionRequest: MovieOptionRequest): ResponseEntity<List<Movie>> {
        val movies = movieService.getMoviesByOptions(movieOptionRequest)
        return ResponseEntity.ok(movies)
    }

    @GetMapping("/movies/page")
    fun getMoviesWithAvgRatings(
            @RequestParam("page", defaultValue = "0") page: Int,
            @RequestParam("size", defaultValue = "10") size: Int
    ): ResponseEntity<Page<MovieWithAvgRatingProjection>> {
        val movies = movieService.findMoviesWithAvgRatings(page, size)
        return ResponseEntity.ok(movies)
    }


    @PutMapping("/movies")
    fun updateMovie(@RequestBody movieUpdateRequest: MovieUpdateRequest): ResponseEntity<MovieInfo> {
        val movieInfo = movieService.updateMovie(movieUpdateRequest)
        return ResponseEntity.ok(movieInfo)
    }

    @DeleteMapping("/movies/{id}")
    fun deleteMovie(@PathVariable("id") id: Long): ResponseEntity<MovieInfo> {
        val movieInfo = movieService.deleteMovie(id)
        return ResponseEntity.ok(movieInfo)
    }

}