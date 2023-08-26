package com.example.goodnight2ndhackathonbackend.domain.movie.dto

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.MovieGenre
import java.time.LocalDate

data class MovieCreateRequest ( //(data class)는 equals(), hashCode(), toString() 등의 메서드를 자동으로 생성
        val title: String,
        val genre: MovieGenre,
        val releaseDate: LocalDate,
        val endDate: LocalDate,
        val showing: Boolean

    )