import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.activies.OverviewActivity
import com.example.movieapp.models.Movie

class MovieAdapter(val context : Context, val movies : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var avatarMovie : ImageView
        var nameMovie : TextView
       // var nameMovie : TextView
        init {
           itemView.layoutParams = RecyclerView.LayoutParams(
               RecyclerView.LayoutParams.MATCH_PARENT,
               RecyclerView.LayoutParams.WRAP_CONTENT
           )
             avatarMovie = itemView.findViewById(R.id.avatarMovie)
             nameMovie = itemView.findViewById(R.id.nameMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, null, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie = movies.get(position)
        var url = "https://image.tmdb.org/t/p/w500/" + movie.poster_path
        Glide.with(context).load(url).into(holder.avatarMovie)
        holder.nameMovie.text = movie.title

        holder.itemView.setOnClickListener {
            var intent = Intent(context, OverviewActivity::class.java)
            intent.putExtra("movie",movie)
            context.startActivity(intent)
        }
    }
}