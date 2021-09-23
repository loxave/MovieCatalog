package com.zen4r17.moviecatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zen4r17.moviecatalog.models.Movie
import com.zen4r17.moviecatalog.models.MovieResponse
import com.zen4r17.moviecatalog.services.MovieApiInterface
import com.zen4r17.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var movie_adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        getMovieData {
                movies: List<Movie> ->
            movie_adapter = MovieAdapter(movies)
            rv_movies_list.adapter = movie_adapter
            // Move with intent
            movie_adapter.onClickItem = {
                val move = Intent(this,MovieDetailActivity::class.java)
                move.putExtra(MovieDetailActivity.EXTRA, it)
                startActivity(move)
            }
        }
        rv_movies_list.setHasFixedSize(true)
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {

        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)

        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            return callback(response)
            }
        })
    }


}