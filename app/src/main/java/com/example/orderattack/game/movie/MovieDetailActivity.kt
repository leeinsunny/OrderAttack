package com.example.orderattack.game.movie

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
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
        val movieTitle = intent.getStringExtra("MOVIE_TITLE") ?: ""

        // ImageView를 찾아서 해당 이미지 리소스로 설정합니다.
        val movieDetailImageView: ImageView = findViewById(R.id.movieDetail)

        val imgTouch: ImageView = findViewById(R.id.img_touch)

        if (movieImageResId != 0) { // 유효한 리소스 ID인 경우에만 설정
            movieDetailImageView.setImageResource(movieImageResId)

            if (movieTitle == "웡카") {
                imgTouch.visibility = View.VISIBLE
            } else {
                imgTouch.visibility = View.GONE
            }
        }



        // 예매 버튼 클릭 리스너
        findViewById<Button>(R.id.reserveBtn).setOnClickListener {
            if (movieTitle == "웡카") {
                val resultIntent = Intent()
                resultIntent.putExtra("MOVIE_DETAIL_ID", movieImageResId)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                showRetryPopup()
            }
        }

        // backBtn 클릭 리스너 설정
        findViewById<Button>(R.id.backBtn).setOnClickListener {
            // 현재 액티비티를 종료하고 이전 화면으로 돌아감
            finish()
        }

    }

    private fun showRetryPopup() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_comment_retry)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.setCancelable(true)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onMovieClick(movie: MovieItem) {
    }

    override fun onReserveClick(movie: MovieItem) {

    }

}