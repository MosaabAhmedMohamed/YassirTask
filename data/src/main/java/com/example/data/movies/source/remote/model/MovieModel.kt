package com.example.data.movies.source.remote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class MovieModel(
    @ColumnInfo(name = "overview")
    val overview: String? = null,
    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String? = null,
    @ColumnInfo(name = "originalTitle")
    val originalTitle: String? = null,
    @ColumnInfo(name = "video")
    val video: Boolean? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @SerializedName("poster_path")
    @ColumnInfo(name = "posterPath")
    val posterPath: String? = null,
    @ColumnInfo(name = "backdropPath")
    val backdropPath: String? = null,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String? = null,
    @ColumnInfo(name = "voteAverage")
    val voteAverage: Long? = null,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "adult")
    val adult: Boolean? = null,
    @ColumnInfo(name = "voteCount")
    val voteCount: Int? = null,
    @ColumnInfo(name = "page")
    var page: Int,
)