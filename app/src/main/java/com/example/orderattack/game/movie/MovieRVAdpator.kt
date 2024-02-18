package com.example.orderattack.game.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R
import java.sql.Time
import java.util.Date

// MovieRVAdapter.kt 파일 내에 추가
interface MovieItemClickListener {
    fun onMovieClick(movie: MovieItem)
    fun onReserveClick(movie: MovieItem)
}

class MovieRVAdapter(
    private val moviesList: List<MovieItem>,
    private val listener: MovieItemClickListener // 인터페이스 추가
) : RecyclerView.Adapter<MovieRVAdapter.MovieViewHolder>() {
    // 나머지 코드는 동일하게 유지
    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val moviePoster: ImageView = view.findViewById(R.id.imageView_movie_poster)
        val reserveBtn: Button = view.findViewById(R.id.reserve_btn)

        // 구현 부분 변경
        init {
            moviePoster.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onMovieClick(moviesList[position])
                }
            }

            reserveBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onReserveClick(moviesList[position])
                }
            }
        }
    }

    // 뷰홀더 생성 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }

    // 뷰홀더에 데이터 바인딩 함수
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.moviePoster.setImageResource(movie.imageResId)
    }

    override fun getItemCount() = moviesList.size
}