package com.zen4r17.moviecatalog.Home

import okhttp3.Response

interface MovieView : com.zen4r17.moviecatalog.Base.View {

    fun onProgress()

    fun onSuccess(response: Response)


}