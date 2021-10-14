package com.zen4r17.moviecatalog.Home

import com.zen4r17.moviecatalog.Base.Presenter

class MoviePresenter : Presenter<MovieView> {

    private var view: MovieView? = null


    override fun onAttach(view: MovieView) {
        this.view = null
    }

    override fun onDetach() {
        view = null
    }


}