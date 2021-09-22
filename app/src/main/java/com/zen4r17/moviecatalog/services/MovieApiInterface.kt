package com.zen4r17.moviecatalog.services

import com.zen4r17.moviecatalog.models.MovieDetailResponse
import com.zen4r17.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=a23df1152eff37dc83b5ef4e931534c4")
    fun getMovieList(): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=a23df1152eff37dc83b5ef4e931534c4")
    fun getDetailMovie(
        @Path("movie_id") movie_id: Int
    ): Call<MovieDetailResponse>
}