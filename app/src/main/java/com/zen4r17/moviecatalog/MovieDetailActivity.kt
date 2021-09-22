package com.zen4r17.moviecatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zen4r17.moviecatalog.models.MovieDetailResponse
import kotlinx.android.synthetic.main.activity_movie_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

//        tv_set_title.text = intent.getStringExtra("TITLE")
//        tv_overview.text = intent.getStringExtra("OVERVIEW")

        val id: Int = intent.getIntExtra("ID", 0)
        getDetailMovie(id)
    }

    private fun getDetailMovie(id: Int) {

        RetrofitClient.instance.getDetailMovie(id)
            .enqueue(object : Callback<MovieDetailResponse>) {

                override fun onResponse(
                    call: Call<MovieDetailResponse>?,
                    response: Response<MovieDetailResponse>?

                ) {
                    if (response!!.isSuccessful) {
                        tv_set_title = response.body().results
                    }
                }

                override fun onFailure(call: Call<MovieDetailResponse>?, t: Throwable?) {

                    Toast.makeText(this@MovieDetailActivity, "Gagal request", Toast.LENGTH_LONG)
                        .show()
                }


            }
    }
}