package com.zen4r17.moviecatalog.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zen4r17.moviecatalog.*
import com.zen4r17.moviecatalog.interfaces.MovieApiInterface
import com.zen4r17.moviecatalog.model.MovieItem
import com.zen4r17.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var movie_adapter: MovieAdapter

    //private lateinit var moviePresenter: MoviePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        getMovieData { movieItems: List<MovieItem> ->
            movie_adapter = MovieAdapter(movieItems)
            rv_movies_list.adapter = movie_adapter


            movie_adapter.onClickItem = {
                val move = Intent(this, MovieDetailActivity::class.java)
                move.putExtra(MovieDetailActivity.EXTRA, it)
                startActivity(move)
            }
        }
        rv_movies_list.setHasFixedSize(true)
    }

    private fun getMovieData(callback: (List<MovieItem>) -> Unit) {

        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)

        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movieItems)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            return callback(response)
            }
        })
    }
}