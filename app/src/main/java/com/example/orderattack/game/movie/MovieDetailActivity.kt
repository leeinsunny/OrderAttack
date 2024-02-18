package com.example.orderattack.game.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R

class MovieDetailActivity : AppCompatActivity(), MovieItemClickListener {

    private lateinit var moviesAdapter: MovieRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // 인텐트에서 전달받은 영화 이미지 리소스 ID를 가져옵니다.
        val movieImageResId = intent.getIntExtra("MOVIE_DETAIL_ID", 0)

        // ImageView를 찾아서 해당 이미지 리소스로 설정합니다.
        val movieDetailImageView: ImageView = findViewById(R.id.movieDetail)
        if (movieImageResId != 0) { // 유효한 리소스 ID인 경우에만 설정
            movieDetailImageView.setImageResource(movieImageResId)
        }

        // 예매 버튼 클릭 리스너
        findViewById<Button>(R.id.reserveBtn).setOnClickListener {
            val resultIntent = Intent()
            // 결과 데이터 설정, 예: 선택된 영화 ID
            resultIntent.putExtra("MOVIE_DETAIL_ID", movieImageResId)
            setResult(RESULT_OK, resultIntent)
            finish() // 액티비티 종료
        }

        // backBtn 클릭 리스너 설정
        findViewById<Button>(R.id.backBtn).setOnClickListener {
            // 현재 액티비티를 종료하고 이전 화면으로 돌아감
            finish()
        }

    }

    override fun onMovieClick(movie: MovieItem) {
    }

    override fun onReserveClick(movie: MovieItem) {

    }

}