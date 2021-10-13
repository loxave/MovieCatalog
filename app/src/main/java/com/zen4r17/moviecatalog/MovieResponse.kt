package com.zen4r17.moviecatalog

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.zen4r17.moviecatalog.model.MovieItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(

    @SerializedName("results")
    val movieItems: List<MovieItem>
) : Parcelable {
    constructor() : this(mutableListOf())
}