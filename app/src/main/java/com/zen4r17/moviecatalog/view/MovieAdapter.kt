package com.zen4r17.moviecatalog.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zen4r17.moviecatalog.R
import com.zen4r17.moviecatalog.model.MovieItem
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movieItems: List<MovieItem>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var onClickItem: ((MovieItem) -> Unit)? = null

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        fun bindMovie(movieItem: MovieItem) {

            itemView.movie_title.text = movieItem.title
            itemView.movie_release_date.text = movieItem.release
            itemView.movie_overview.text = movieItem.overview
            itemView.movie_original_language.text = movieItem.original_language
            itemView.movie_backdrop_path.text = movieItem.backdrop_path
            itemView.movie_original_title.text = movieItem.original_title
            itemView.movie_popularity.text = movieItem.popularity
            Glide.with(itemView).load(IMAGE_BASE + movieItem.poster).into(itemView.movie_poster)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movieItems.get(position))
    }

    override fun getItemCount(): Int = movieItems.size
}