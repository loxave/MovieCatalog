package com.zen4r17.moviecatalog.Home

import com.zen4r17.moviecatalog.model.MovieItem

interface MovieListener {

    fun onClick(movieItem: MovieItem)
}