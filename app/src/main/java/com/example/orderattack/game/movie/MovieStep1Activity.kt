package com.example.orderattack.game.movie

import OnShowtimeClickListener
import ShowtimesAdapter
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MovieStep1Activity : AppCompatActivity(), OnDateClickListener, OnShowtimeClickListener, MovieItemClickListener {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesAdapter: MovieRVAdapter
    private var currentDialogView: View? = null
    private var selectedShowtimeResId: Int = 0 // 클릭된 시간 버튼 저장
    private var selectedMovieTitle: String = "" // 선택된 영화 제목 저장
    private var selectedCinemaName: String = "" // 선택된 영화관 이름 저장
    private var selectedDateResId: Int = 0 // 클릭한 날짜 저장

    private val moviesList = listOf(
        MovieItem(
            "웡카",
            R.drawable.movie_poster1,
            R.drawable.movie1_poster,
            R.drawable.movie1_detail
        ),
        MovieItem(
            "시민덕희",
            R.drawable.movie_poster2,
            R.drawable.movie2_poster,
            R.drawable.movie2_detail
        ),
        MovieItem(
            "소풍",
            R.drawable.movie_poster3,
            R.drawable.movie3_poster,
            R.drawable.movie3_detail
        ),
        MovieItem(
            "도그데이즈",
            R.drawable.movie_poster4,
            R.drawable.movie4_poster,
            R.drawable.movie4_detail
        ),
        MovieItem(
            "데드맨",
            R.drawable.movie_poster5,
            R.drawable.movie5_poster,
            R.drawable.movie5_detail
        ),
        MovieItem(
            "외계+인 2부",
            R.drawable.movie_poster6,
            R.drawable.movie6_poster,
            R.drawable.movie6_detail
        ),
        MovieItem(
            "위시",
            R.drawable.movie_poster7,
            R.drawable.movie7_poster,
            R.drawable.movie7_detail
        ),
        MovieItem(
            "추락의 해부",
            R.drawable.movie_poster8,
            R.drawable.movie8_poster,
            R.drawable.movie8_detail
        ),
        MovieItem(
            "서울의 봄",
            R.drawable.movie_poster9,
            R.drawable.movie9_poster,
            R.drawable.movie9_detail
        ),
        MovieItem(
            "아가일",
            R.drawable.movie_poster10,
            R.drawable.movie10_poster,
            R.drawable.movie10_detail
        ),
        MovieItem(
            "인투 더 월드",
            R.drawable.movie_poster11,
            R.drawable.movie11_poster,
            R.drawable.movie11_detail
        )
    )
    private var datesList: List<DateItem> = listOf()

    private fun initializeOrUpdateDatesList() {
        datesList = listOf(
            DateItem("1", R.drawable.date0_btn, R.drawable.date0_selected_btn, true),
            DateItem("2", R.drawable.date1_btn, R.drawable.date1_selected_btn, false),
            DateItem("3", R.drawable.date2_btn, R.drawable.date2_selected_btn, false),
            DateItem("4", R.drawable.date3_btn, R.drawable.date3_selected_btn, false),
            DateItem("5", R.drawable.date4_btn, R.drawable.date4_selected_btn, false),
            DateItem("6", R.drawable.date5_btn, R.drawable.date5_selected_btn, false),
            DateItem("7", R.drawable.date6_cant_selected_btn, R.drawable.date6_selected_btn, false, false),
            DateItem("8", R.drawable.date7_cant_selected_btn, R.drawable.date7_selected_btn, false, false),
            DateItem("9", R.drawable.date8_cant_selected_btn, R.drawable.date8_selected_btn, false, false),
            DateItem("10", R.drawable.date9_cant_selected_btn, R.drawable.date9_selected_btn, false, false),
            DateItem("11", R.drawable.date10_cant_selected_btn, R.drawable.date10_selected_btn, false, false),
            DateItem("12", R.drawable.date11_cant_selected_btn, R.drawable.date11_selected_btn, false, false),
            DateItem("13", R.drawable.date12_cant_selected_btn, R.drawable.date12_selected_btn, false, false)
        )
    }

    private val showtimesList = listOf(
        TimeItem(R.drawable.time_btn1),
        TimeItem(R.drawable.time_btn2),
        TimeItem(R.drawable.time_btn3),
        TimeItem(R.drawable.time_btn4),
        TimeItem(R.drawable.time_btn5),
        TimeItem(R.drawable.time_btn6),
        TimeItem(R.drawable.time_btn7),
        TimeItem(R.drawable.time_btn8),
        TimeItem(R.drawable.time_btn9),
        TimeItem(R.drawable.time_btn10),
        TimeItem(R.drawable.time_btn11),
        TimeItem(R.drawable.time_btn12),
        TimeItem(R.drawable.time_btn13),
        TimeItem(R.drawable.time_btn14),
        TimeItem(R.drawable.time_btn15),
        TimeItem(R.drawable.time_btn16),
        TimeItem(R.drawable.time_btn17),
        TimeItem(R.drawable.time_btn18),
        TimeItem(R.drawable.time_btn19),
        TimeItem(R.drawable.time_btn20)
    )

    private val cinemasList = listOf(
        CinemaItem("가산디지털", "서울"),
        CinemaItem("가양", "서울"),
        CinemaItem("강동", "서울"),
        CinemaItem("건대입구", "서울"),
        CinemaItem("김포공항", "서울"),
        CinemaItem("노원", "서울"),
        CinemaItem("도곡", "서울"),
        CinemaItem("독산", "서울"),
        CinemaItem("브로드웨이(신사)", "서울"),
        CinemaItem("서울대입구", "서울"),
        CinemaItem("수락산", "서울"),
        CinemaItem("수유", "서울"),
        CinemaItem("신대방(구로디지털역)", "서울"),
        CinemaItem("신도림", "서울"),
        CinemaItem("신림", "서울"),
        CinemaItem("에비뉴엘(명동)", "서울"),
        CinemaItem("영등포", "서울"),
        CinemaItem("용산", "서울"),
        CinemaItem("월드타워", "서울"),
        CinemaItem("은평(롯데몰)", "서울"),
        CinemaItem("중랑", "서울"),
        CinemaItem("청량리", "서울"),
        CinemaItem("합정", "서울"),
        CinemaItem("홍대입구", "서울"),

        CinemaItem("인천터미널", "경기/인천"),
        CinemaItem("동탄", "경기/인천"),
        CinemaItem("마석", "경기/인천"),
        CinemaItem("안성", "경기/인천"),
        CinemaItem("안산", "경기/인천"),

        CinemaItem("당진", "충청/대전"),
        CinemaItem("대전", "충청/대전"),
        CinemaItem("서산", "충청/대전"),
        CinemaItem("청주용암", "충청/대전"),
        CinemaItem("충주(모다아울렛)", "충청/대전"),

        CinemaItem("광주(백화점)", "전라/광주"),
        CinemaItem("군산몰", "전라/광주"),
        CinemaItem("전주(백화점)", "전라/광주"),
        CinemaItem("전주송천", "전라/광주"),
        CinemaItem("충장로", "전라/광주"),

        CinemaItem("경주", "경북/대구"),
        CinemaItem("대구광장", "경북/대구"),
        CinemaItem("포항", "경북/대구"),
        CinemaItem("영주", "경북/대구"),
        CinemaItem("영천", "경북/대구"),

        CinemaItem("동래", "경남/부산/울산"),
        CinemaItem("서면", "경남/부산/울산"),
        CinemaItem("김해아울렛(장유)", "경남/부산/울산"),
        CinemaItem("부산본점", "경남/부산/울산"),
        CinemaItem("창원", "경남/부산/울산"),

        CinemaItem("남원주", "강원"),
        CinemaItem("동해", "강원"),
        CinemaItem("원주무실", "강원"),
        CinemaItem("춘천", "강원"),

        CinemaItem("서귀포", "제주"),
        CinemaItem("제주아라", "제주"),
        CinemaItem("제주연동", "제주")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_step3)

        initializeOrUpdateDatesList()

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val detailId = result.data?.getIntExtra("MOVIE_DETAIL_ID", 0)
                    val movieItem = moviesList.find { it.detailId == detailId }

                    if (movieItem != null) {
                        showCinemaSetDialog(movieItem)
                    }

                }
            }

        recyclerView = findViewById(R.id.rv_movies)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        moviesAdapter = MovieRVAdapter(moviesList, this) // this로 현재 액티비티를 리스너로 설정
        recyclerView.adapter = moviesAdapter
    }


    // 인터페이스 구현
    override fun onMovieClick(movie: MovieItem) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("MOVIE_DETAIL_ID", movie.detailId)
        resultLauncher.launch(intent)
    }


    override fun onReserveClick(movie: MovieItem) {
        // 예매 버튼 클릭 시 다이얼로그 표시 로직
        showCinemaSetDialog(movie)
    }

    override fun onDateClicked(dateResId: Int) {

        selectedDateResId = dateResId
        val dialogView = currentDialogView // 현재 활성화된 다이얼로그 뷰를 얻어오는 로직 필요
        val dateItem = datesList.find { it.clickedImageResId == selectedDateResId }
        val isPlayedAtTheDate = dateItem!!.isPlayed
        val isNotSelectedCinema = cinemasList.none { it.isClicked }

        // 영화관이 선택되지 않은 경우
        if (isNotSelectedCinema) {
            dialogView?.findViewById<RecyclerView>(R.id.rv_showtimes)?.visibility = View.GONE
            dialogView?.findViewById<TextView>(R.id.tv_no_selection)?.visibility = View.VISIBLE
            dialogView?.findViewById<TextView>(R.id.tv_not_played)?.visibility = View.GONE
        } else {
            if(isPlayedAtTheDate) {
                dialogView?.findViewById<RecyclerView>(R.id.rv_showtimes)?.visibility = View.VISIBLE
                dialogView?.findViewById<TextView>(R.id.tv_no_selection)?.visibility = View.GONE
                dialogView?.findViewById<TextView>(R.id.tv_not_played)?.visibility = View.GONE
            } else {
                dialogView?.findViewById<RecyclerView>(R.id.rv_showtimes)?.visibility = View.GONE
                dialogView?.findViewById<TextView>(R.id.tv_no_selection)?.visibility = View.GONE
                dialogView?.findViewById<TextView>(R.id.tv_not_played)?.visibility = View.VISIBLE
            }
        }

    }


    override fun onShowtimeClicked(imageResId: Int) {
        // 클릭된 showtime의 imageResId 저장
        selectedShowtimeResId = imageResId
        val intent = Intent(this, ReserveActivity::class.java).apply {
            putExtra("MOVIE_TITLE", selectedMovieTitle)
        }
        this.startActivity(intent)
    }


    private fun showCinemaSetDialog(movie: MovieItem) {

        // BottomSheetDialog 인스턴스 생성
        val bottomSheetDialog =
            BottomSheetDialog(this, R.style.FullHeightBottomSheetDialog) // 커스텀 스타일 적용
        val dialogView = layoutInflater.inflate(R.layout.dialog_movie_setting, null)
        bottomSheetDialog.setContentView(dialogView)

        // BottomSheetDialog의 높이를 조정하기 위한 레이아웃 파라미터 설정
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
        val layoutParams = bottomSheet?.layoutParams
        layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT
        bottomSheet?.layoutParams = layoutParams

        // BottomSheetBehavior를 가져와서 상태를 STATE_EXPANDED로 설정
        val behavior = BottomSheetBehavior.from(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        currentDialogView = dialogView

        selectedMovieTitle = movie.title

        // 선택한 영화의 포스터 설정
        val dialogMoviePoster: ImageView = dialogView.findViewById(R.id.dialogMoviePoster)
        dialogMoviePoster.setImageResource(movie.posterResId)

        // 영화관 설정 버튼 추가
        val dialogSelectTheaterBtn: ImageButton =
            dialogView.findViewById(R.id.dialogSelectTheaterBtn)
        val includedCinemaLayout: View = dialogView.findViewById(R.id.selectedCinemaLayout)
        val includedCinemaBtn: ImageButton =
            includedCinemaLayout.findViewById(R.id.selectedCinemaBtn)

        initializeOrUpdateDatesList()

        // 지역 선택 버튼
        if (dialogSelectTheaterBtn.visibility == View.VISIBLE) {
            dialogSelectTheaterBtn.setOnClickListener {
                showRegionSelectionDialog(dialogView)
            }
        }

        includedCinemaBtn.setOnClickListener {
            showRegionSelectionDialog(dialogView)
        }


        // 날짜 recyclerView 설정
        val datesRecyclerView: RecyclerView =
            dialogView.findViewById(R.id.dialog_dates_recyclerview)


        val datesAdapter = DatesAdapter(datesList, this)
        datesRecyclerView.adapter = datesAdapter
        datesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        // BottomSheetDialog 표시
        bottomSheetDialog.show()
    }


    private fun showRegionSelectionDialog(view: View) {

        val bottomSheetDialog = BottomSheetDialog(this, R.style.NotFullHeightBottomSheetDialog)
        val dialogView = layoutInflater.inflate(R.layout.dialog_region_selection, null)
        bottomSheetDialog.setContentView(dialogView)

        // 지역 버튼 클릭 리스너 설정
        dialogView.findViewById<Button>(R.id.seoulBtn).setOnClickListener {
            showCinemaListOfRegion("서울", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.ggIcnBtn).setOnClickListener {
            showCinemaListOfRegion("경기/인천", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.ccDjBtn).setOnClickListener {
            showCinemaListOfRegion("충청/대전", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.jlGjBtn).setOnClickListener {
            showCinemaListOfRegion("전라/광주", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.gbDgBtn).setOnClickListener {
            showCinemaListOfRegion("경북/대구", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.gnBsnUsnBtn).setOnClickListener {
            showCinemaListOfRegion("경남/부산/울산", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.gwBtn).setOnClickListener {
            showCinemaListOfRegion("강원", bottomSheetDialog, view)
        }

        dialogView.findViewById<Button>(R.id.jejuBtn).setOnClickListener {
            showCinemaListOfRegion("제주", bottomSheetDialog, view)
        }

        bottomSheetDialog.show()
    }


    private fun showCinemaListOfRegion(region: String, bsdialog: BottomSheetDialog, view: View) {
        val cinemasInRegion = getCinemasOfRegion(region)
        val dialogView = layoutInflater.inflate(R.layout.dialog_cinema_list, null)
        val recyclerView: RecyclerView = dialogView.findViewById(R.id.cinemaListRecyclerView)

        val dialog = Dialog(this).apply {
            setContentView(dialogView)
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CinemaAdapter(cinemasInRegion) { cinema ->
            cinemasInRegion.forEach { it.isClicked = false }
            cinema.isClicked = true
            selectedCinemaName = cinema.cinemaName
            updateSelectedTheater(cinema.cinemaName, view)
            checkShowtimes(cinema, view)
            dialog.dismiss()
            bsdialog.dismiss()
        }

        dialog.show()
    }


    private fun updateSelectedTheater(selectedCinemaName: String, dialogView: View) {

        val dialogSelectTheaterBtn: ImageButton =
            dialogView.findViewById(R.id.dialogSelectTheaterBtn)
        val includedCinemaLayout: View = dialogView.findViewById(R.id.selectedCinemaLayout)

        dialogSelectTheaterBtn.visibility = View.GONE
        includedCinemaLayout.visibility = View.VISIBLE

        val selectedCinemaBtnText: TextView =
            includedCinemaLayout.findViewById(R.id.selectedCinemaName)
        selectedCinemaBtnText.text = selectedCinemaName

    }


    fun getCinemasOfRegion(region: String): List<CinemaItem> {
        return (cinemasList).filter { it.region == region }
    }



    private fun checkShowtimes(cinemaItem: CinemaItem, dialogView: View) {

        // 선택된 영화관이 있는지 확인
        val isSelectedCinemaExists = cinemaItem.isClicked

        if (selectedDateResId == 0) {
            val defaultDateItem = datesList.find { it.id == "1" }
            defaultDateItem?.let {
                selectedDateResId = it.clickedImageResId
            }
        }

        val dateItem = datesList.find { it.clickedImageResId == selectedDateResId }
        val isPlayedAtTheDate = dateItem!!.isPlayed

        // 선택된 영화관이 있으면 상영시간 리스트를 업데이트
        if (isSelectedCinemaExists && isPlayedAtTheDate) {
            bringShowtimes(dialogView)
        } else {
            if(!isPlayedAtTheDate) {
                dialogView.findViewById<RecyclerView>(R.id.rv_showtimes).visibility = View.GONE
                dialogView.findViewById<TextView>(R.id.tv_no_selection).visibility = View.GONE
                dialogView.findViewById<TextView>(R.id.tv_not_played).visibility = View.VISIBLE
            } else {
                dialogView.findViewById<RecyclerView>(R.id.rv_showtimes).visibility = View.GONE
                dialogView.findViewById<TextView>(R.id.tv_no_selection).visibility = View.VISIBLE
                dialogView.findViewById<TextView>(R.id.tv_not_played).visibility = View.GONE
            }
        }
    }


    private fun bringShowtimes(dialogView: View) {

        val showtimesRecyclerView: RecyclerView = dialogView.findViewById(R.id.rv_showtimes)

        showtimesRecyclerView.visibility = View.VISIBLE
        dialogView.findViewById<TextView>(R.id.tv_no_selection).visibility = View.GONE
        dialogView.findViewById<TextView>(R.id.tv_not_played).visibility = View.GONE

        val showtimesAdapter = ShowtimesAdapter(showtimesList, this)
        showtimesRecyclerView.adapter = showtimesAdapter
        showtimesRecyclerView.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false)

    }

}