package com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity

import com.example.goodnight2ndhackathonbackend.domain.movie.dto.MovieUpdateRequest
import com.example.goodnight2ndhackathonbackend.global.common.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "movies")
class Movie (    //코틀린에서는 클래스의 생성자를 정의할 때 괄호 () 안에 생성자의 매개변수를 나열한다. val(읽기전용), var(다)
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

        @Column(nullable = false)
    var title: String,

        @Enumerated(EnumType.STRING) @Column
    var genre: MovieGenre,

        @Column(nullable = false)
    var releaseDate: LocalDate,

        @Column(nullable = false)
    var endDate: LocalDate,

        @Column(nullable = false)
    var showing: Boolean,

        @Column(nullable = false)
    var isDeleted: Boolean = false
): BaseEntity(){
    fun updateMovie(movieUpdateRequest: MovieUpdateRequest) {
        this.title = movieUpdateRequest.title
        this.genre = movieUpdateRequest.genre
        this.releaseDate = movieUpdateRequest.releaseDate
        this.endDate = movieUpdateRequest.endDate
        this.showing = movieUpdateRequest.showing
    }
}

