import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

class GenreIds(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name : String) {

    companion object {
        fun getGenreIds() : List<GenreIds>{
            return Gson().fromJson(GenreIdsDatabase.genreIds, object : TypeToken<List<GenreIds>>(){}.type)
        }
    }

}