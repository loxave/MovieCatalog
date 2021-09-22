package com.zen4r17.moviecatalog.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Movie(
    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("release_date")
    val release: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("original_language")
    val original_language: String?,

    @SerializedName("original_title")
    val original_title: String?,

    @SerializedName("backdrop_path")
    val backdrop_path: String?,

    @SerializedName("popularity")
    val popularity: String?,


    ) : Parcelable {
    constructor() : this("", "", "", "", "", "", "", "", "")
}