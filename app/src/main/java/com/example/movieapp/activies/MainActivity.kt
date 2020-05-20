package com.example.movieapp.activies

import MovieAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.models.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)

        recycler_view.adapter = MovieAdapter(this, Movie.getMovies())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.itemId
        if (id == R.id.linear_action){
           recycler_view.layoutManager = LinearLayoutManager(this)
        }
        else {
           recycler_view.layoutManager = GridLayoutManager(this, 3)
        }
        return super.onOptionsItemSelected(item)
    }
}
