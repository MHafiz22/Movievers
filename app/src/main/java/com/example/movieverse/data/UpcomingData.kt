package com.example.movieverse.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpcomingData(
    val upcomingimg: Int,
    val upcomingname: String,
    val upcomingdate: String,
    val upcomingauthor: String,
    val upcomingdesc: String,
    val upcominggenre: String
) : Parcelable