package com.example.pagingcourse.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RickMorty(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable