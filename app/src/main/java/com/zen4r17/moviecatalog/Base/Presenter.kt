package com.zen4r17.moviecatalog.Base

interface Presenter<in T: View> {

    fun onAttach(view : T)

    fun onDetach()
}