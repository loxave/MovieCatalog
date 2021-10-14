package com.zen4r17.moviecatalog.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zen4r17.moviecatalog.R
import com.zen4r17.moviecatalog.model.MovieItem
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private var dataFilm: MovieItem? = null

    companion object {

        const val EXTRA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
//        val id: Int = intent.getIntExtra("ID", 0)
//        getDetailMovie(id)

        dataFilm = intent.getParcelableExtra(EXTRA)

        if (dataFilm!= null) {

            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this)
                .load(IMAGE_BASE + dataFilm?.poster)
                .apply(RequestOptions())
                .into(movie_poster_detail)

            movie_title_detail.text = dataFilm?.title
            tv_overview.text = dataFilm?.overview
        }

        btn_back.setOnClickListener {

            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }
    }
}