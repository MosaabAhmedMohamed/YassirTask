package com.example.data.moviedetails.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieDetailsLocal(
    val title: String? = null,
    val backdropPath: String? = null,
    val genres: List<String>? = null,
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val overview: String? = null,
    val originalTitle: String? = null,
    val runtime: Long? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Float? = null,
    val tagline: String? = null,
)
