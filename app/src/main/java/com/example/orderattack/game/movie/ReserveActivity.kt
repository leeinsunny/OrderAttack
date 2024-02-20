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
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class ReserveActivity : AppCompatActivity() {

    private val viewerViewModel: ViewerViewModel by viewModels()
    private lateinit var seatsRecyclerView: RecyclerView
    private lateinit var seatsAdapter: SeatsAdapter
    private var seatsList: MutableList<Seat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve)

        // 인텐트에서 영화 제목을 받음
        val movieTitle = intent.getStringExtra("MOVIE_TITLE") ?: "Default Movie Title"

        // 받은 영화 제목을 TextView에 설정
        findViewById<TextView>(R.id.tv_movie_name).text = movieTitle

        showViewerSelectionDialog()

        val btnResetViewers: ImageButton = findViewById(R.id.btn_reset_viewers)
        btnResetViewers.setOnClickListener {
            // BottomSheetDialog를 다시 표시
            showViewerSelectionDialog()
        }

        seatsRecyclerView = findViewById(R.id.rv_seats)
        seatsList = initializeSeats()

        val layoutManager = GridLayoutManager(this, 8)
        seatsRecyclerView.layoutManager = layoutManager
        seatsAdapter = SeatsAdapter(this, seatsList) { seat ->
            onSeatClicked(seat)
        }
        seatsRecyclerView.adapter = seatsAdapter

        val btnProceedToPayment: Button = findViewById(R.id.btn_pay)
        btnProceedToPayment.setOnClickListener {
            startPaymentProcess()
        }

    }


    private fun initializeSeats(): MutableList<Seat> {

        val seats = mutableListOf<Seat>()
        ('A'..'N').forEach { row ->
            (1..8).forEach { number ->
                seats.add(Seat(row, "$row${number.toString().padStart(2, '0')}", true, true, false))
            }
        }

        return seats
    }


    private fun onSeatClicked(clickedSeat: Seat) {
        if (!clickedSeat.isSelected && seatsList.count { it.isSelected } < viewerViewModel.totalViewers) {
            clickedSeat.isSelected = true
        } else if (clickedSeat.isSelected) {
            clickedSeat.isSelected = false
        }

        val totalSelectedSeats = seatsList.count { it.isSelected }
        seatsList.forEach { seat ->
            if (!seat.isSelected) {
                seat.isAvailable = totalSelectedSeats < viewerViewModel.totalViewers
            }
        }

        seatsAdapter.notifyDataSetChanged()

        updateSelectedSeatsDisplay()
        updatePaymentButtonVisibility()
    }


    private fun updateSelectedSeatsDisplay() {
        val selectedSeatsText = seatsList.filter { it.isSelected }.joinToString(separator = ", ") { it.seatNumber }
        findViewById<TextView>(R.id.tv_seats_plz).text = selectedSeatsText
        findViewById<TextView>(R.id.tv_seats_plz).setTextColor(ContextCompat.getColor(this, R.color.black))
    }


    private fun updatePaymentButtonVisibility() {
        val btnProceedToPayment: Button = findViewById(R.id.btn_pay)
        val imgTouch: ImageView = findViewById(R.id.img_touch)
        btnProceedToPayment.visibility =
            if (seatsList.count { it.isSelected } == viewerViewModel.totalViewers) View.VISIBLE else View.GONE
        imgTouch.visibility =
            if (seatsList.count { it.isSelected } == viewerViewModel.totalViewers) View.VISIBLE else View.GONE
    }


    private fun showViewerSelectionDialog() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.dialog_viewer_selection, null)
        dialog.setContentView(view)

        // 다이얼로그 외부 클릭에 의한 닫힘 방지
        dialog.setCancelable(false)

        // ViewModel에서 인원 수를 가져와서 TextView에 설정합니다.
        val adultCountView: TextView = view.findViewById(R.id.tv_adult_count)
        val teenagerCountView: TextView = view.findViewById(R.id.tv_teenager_count)
        val seniorCountView: TextView = view.findViewById(R.id.tv_senior_count)
        val handicapCountView: TextView = view.findViewById(R.id.tv_handicap_count)

        adultCountView.text = viewerViewModel.adultCount.toString()
        teenagerCountView.text = viewerViewModel.teenagerCount.toString()
        seniorCountView.text = viewerViewModel.seniorCount.toString()
        handicapCountView.text = viewerViewModel.handicapCount.toString()

        setupButtonListeners(
            view,
            adultCountView,
            teenagerCountView,
            seniorCountView,
            handicapCountView
        )

        updateButtonsVisibility(view)

        val btnSelectSeatsEnabled: Button = view.findViewById(R.id.btn_select_seats_enabled)
        btnSelectSeatsEnabled.setOnClickListener {
            if(viewerViewModel.seniorCount == 2 && viewerViewModel.totalViewers == 2) {
                updateSelectedInfo()
                dialog.dismiss()
            } else {
                showRetryPopup()
            }
        }

        dialog.show()
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


    private fun updateSelectedInfo() {
        val selectedInfoTextView: TextView = findViewById(R.id.tv_selected_info)
        val selectedInfo = buildSelectedInfoText()
        selectedInfoTextView.text = selectedInfo
    }


    private fun buildSelectedInfoText(): String {
        // 선택된 인원 정보를 문자열로 생성
        val parts = mutableListOf<String>()
        if (viewerViewModel.adultCount > 0) parts.add("성인 ${viewerViewModel.adultCount}")
        if (viewerViewModel.teenagerCount > 0) parts.add("청소년 ${viewerViewModel.teenagerCount}")
        if (viewerViewModel.seniorCount > 0) parts.add("경로 ${viewerViewModel.seniorCount}")
        if (viewerViewModel.handicapCount > 0) parts.add("장애인 ${viewerViewModel.handicapCount}")

        return parts.joinToString(" | ")
    }


    private fun setupButtonListeners(view: View, vararg countViews: TextView) {

        // 성인 수 줄이기 버튼
        view.findViewById<ImageButton>(R.id.btn_minus).setOnClickListener {
            viewerViewModel.updateCount(false, "adult")
            updateCountView(view, "adult", countViews[0])
        }
        // 성인 수 늘리기 버튼
        view.findViewById<ImageButton>(R.id.btn_plus).setOnClickListener {
            viewerViewModel.updateCount(true, "adult")
            updateCountView(view, "adult", countViews[0])
        }

        // 청소년 수 줄이기 버튼
        view.findViewById<ImageButton>(R.id.btn_minus2).setOnClickListener {
            viewerViewModel.updateCount(false, "teenager")
            updateCountView(view, "teenager", countViews[1])
        }
        // 청소년 수 늘리기 버튼
        view.findViewById<ImageButton>(R.id.btn_plus2).setOnClickListener {
            viewerViewModel.updateCount(true, "teenager")
            updateCountView(view, "teenager", countViews[1])
        }

        // 경로 수 줄이기 버튼
        view.findViewById<ImageButton>(R.id.btn_minus3).setOnClickListener {
            viewerViewModel.updateCount(false, "senior")
            updateCountView(view, "senior", countViews[2])
        }
        // 경로 수 늘리기 버튼
        view.findViewById<ImageButton>(R.id.btn_plus3).setOnClickListener {
            viewerViewModel.updateCount(true, "senior")
            updateCountView(view, "senior", countViews[2])
        }

        // 장애인 수 줄이기 버튼
        view.findViewById<ImageButton>(R.id.btn_minus4).setOnClickListener {
            viewerViewModel.updateCount(false, "handicap")
            updateCountView(view, "handicap", countViews[3])
        }
        // 장애인 수 늘리기 버튼
        view.findViewById<ImageButton>(R.id.btn_plus4).setOnClickListener {
            viewerViewModel.updateCount(true, "handicap")
            updateCountView(view, "handicap", countViews[3])
        }

    }

    private fun updateCountView(view: View, countType: String, countView: TextView) {
        val count = when(countType) {
            "adult" -> viewerViewModel.adultCount
            "teenager" -> viewerViewModel.teenagerCount
            "senior" -> viewerViewModel.seniorCount
            "handicap" -> viewerViewModel.handicapCount
            else -> 0
        }
        countView.text = count.toString()
        updateButtonsVisibility(view)
    }


    private fun updateButtonsVisibility(view: View) {
        val btnSelectSeatsEnabled: Button = view.findViewById(R.id.btn_select_seats_enabled)
        val btnSelectSeatsDisabled: Button = view.findViewById(R.id.btn_select_seats_unenabled)
        val imgTouch: ImageView = view.findViewById(R.id.img_touch)

        if (viewerViewModel.totalViewers > 0) {
            btnSelectSeatsEnabled.visibility = View.VISIBLE
            btnSelectSeatsDisabled.visibility = View.GONE
        } else {
            btnSelectSeatsEnabled.visibility = View.GONE
            btnSelectSeatsDisabled.visibility = View.VISIBLE
        }

        if (viewerViewModel.seniorCount == 2 && viewerViewModel.totalViewers == 2) {
            imgTouch.visibility = View.VISIBLE
        } else {
            imgTouch.visibility = View.GONE
        }
    }


    private fun startPaymentProcess() {
        val intent = Intent(this, Step1ClearActivity::class.java)
        this.startActivity(intent)
    }

}