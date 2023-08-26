package com.example.goodnight2ndhackathonbackend.domain.review.domain.entity

import com.example.goodnight2ndhackathonbackend.domain.movie.domain.entity.Movie
import com.example.goodnight2ndhackathonbackend.global.common.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "reviews")
class Review(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "movie_id")
        val movie: Movie,

        @Column(nullable = false)
        var rating: Double,

        @Column(nullable = false)
        var content: String
) : BaseEntity() {

    constructor(movie: Movie, rating: Double, content: String) : this(null, movie, rating, content)
}