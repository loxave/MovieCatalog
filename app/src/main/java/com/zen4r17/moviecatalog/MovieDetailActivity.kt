package com.zen4r17.moviecatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zen4r17.moviecatalog.models.Movie
import com.zen4r17.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.view.*
import kotlinx.android.synthetic.main.movie_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailActivity : AppCompatActivity() {

    private var data: Movie? = null

    companion object {

        const val EXTRA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

//        val id: Int = intent.getIntExtra("ID", 0)
//        getDetailMovie(id)

        data = intent.getParcelableExtra(EXTRA)

        if (data != null) {

            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this)
                .load(IMAGE_BASE + data?.poster)
                .apply(RequestOptions())
                .into(movie_poster_detail)

            movie_title_detail.text = data?.title
            tv_overview.text = data?.overview
        }

        btn_back.setOnClickListener {

            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

    }
}

//    private fun getDetailMovie(id: Int) {
//
//        MovieApiService.getInstance.getDetailMovie()
//      //  MovieApiService.getInstance().create(MovieDetailResponse::class.java)
//            //MovieApiService.getInstance(getDetailMovie())
//            //MovieApiService.instance.getDetailMovie(id)
//            .enqueue(object : Callback<MovieDetailResponse> by) {
//
//                override fun onResponse(
//                    call: Call<MovieDetailResponse>?,
//                    response: Response<MovieDetailResponse>?
//
//                ) {
//                    if (response!!.isSuccessful) {
//
//                        tv_set_title.text = response.body()!!.originalTitle
//                        tv_overview.text = response.body()!!.overview
//
//                    }
//                }
//
//
//                override fun onFailure(call: Call<MovieDetailResponse>?, t: Throwable?) {
//
//                    Toast.makeText(this@MovieDetailActivity, "Gagal request", Toast.LENGTH_LONG)
//                        .show()
//                }
//
//            }
//    }
//}