package com.zen4r17.moviecatalog

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val listMovie = listOf(
//            Movie(
//                title = "Kate",
//                poster = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg",
//                release = ""
//            ),
//            Movie(
//                title = "Kate",
//                poster = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg",
//                release = ""
//            ),
//            Movie(
//                title = "Kate",
//                poster = "\"https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg",
//                release = ""
//            ),
//        )

//        val movieAdapter = MovieAdapter(listMovie)

//        rv_movies_list.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = movieAdapter
//        }

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)

        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
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