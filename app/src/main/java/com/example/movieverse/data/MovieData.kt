package com.example.movieverse.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(
    val movieimg: Int,
    val moviename: String,
    val moviedate: String,
    val movieauthor: String,
    val moviedesc: String,
    val movierate: String,
    val movieratingbar: Double,
    val moviegenre: String
) : Parcelable