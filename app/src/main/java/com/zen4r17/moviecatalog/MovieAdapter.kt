package com.zen4r17.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zen4r17.moviecatalog.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        fun bindMovie(movie: Movie) {

            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release
            itemView.movie_overview.text = movie.overview
            itemView.movie_original_language.text = movie.original_language
            itemView.movie_backdrop_path.text = movie.backdrop_path
            itemView.movie_original_title.text = movie.original_title
            itemView.movie_popularity.text = movie.popularity
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size
}