package com.example.movieapp.activies

import GenreAddapter
import GenreIds
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.models.Movie
import kotlinx.android.synthetic.main.item_movie_overview.*

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_movie_overview)

        recyclerview_geners.layoutManager = GridLayoutManager(this, 4)
        recyclerview_geners.hasFixedSize()


        var movie = intent.extras?.getParcelable<Movie>("movie")


        if (movie != null) {
            var url = "https://image.tmdb.org/t/p/w500/" + (movie.poster_path)
            Glide.with(this).load(url).into(avatarMovie)
            vote_average.text = movie.vote_average.toString()
            popularity.text = movie.popularity.toString() + " views"
            vote_count.text = movie.vote_count.toString() + " votes"
            adult.text = when(movie.adult){
                true -> "Yes"
                else -> "No"
            }
            ratingbar.rating = movie.vote_average / 2
            language.text = "Language: " + movie.original_language
            release_date.text = movie.release_date
            nameMovie.text = movie.original_title
            overview.text = movie.overview

           var genres : List<GenreIds> = movie.genre_ids.map { id -> when(id){
               28 -> GenreIds(id, "Action")
               12 -> GenreIds(id, "Adventure")
               16 -> GenreIds(id, "Animation")
               35 -> GenreIds(id, "Comedy")
               80 -> GenreIds(id, "Crime")
               99 -> GenreIds(id, "Documentary")
               18 -> GenreIds(id, "Drama")
               10751 -> GenreIds(id, "Family")
               14 -> GenreIds(id, "Fantasy")
               36 -> GenreIds(id, "History")
               27 -> GenreIds(id, "Horror")
               10402 -> GenreIds(id, "Music")
               9648 -> GenreIds(id, "Mystery")
               10749 -> GenreIds(id, "Romance")
               878 -> GenreIds(id, "Science Fiction")
               10770 -> GenreIds(id, "TV Movie")
               53 -> GenreIds(id, "Thriller")
               10752 -> GenreIds(id, "War")
               37 -> GenreIds(id, "Western")
               else -> GenreIds(id, "I don't know")
           } }

            recyclerview_geners.adapter = GenreAddapter(genres,this)
        }
    }
}
