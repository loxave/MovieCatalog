package com.zen4r17.moviecatalog.services

import com.zen4r17.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface  {

    @GET("/3/movie/popular?api_key=a23df1152eff37dc83b5ef4e931534c4")
    fun getMovieList(): Call<MovieResponse>
}