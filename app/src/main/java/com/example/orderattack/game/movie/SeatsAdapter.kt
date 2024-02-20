package com.example.orderattack.game.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R

class SeatsAdapter(private val context: Context, private val seats: List<Seat>, private val onSeatClick: (Seat) -> Unit) : RecyclerView.Adapter<SeatsAdapter.SeatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.seat_item, parent, false)
        return SeatViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatViewHolder, position: Int) {
        holder.bind(context, seats[position], onSeatClick)
    }

    override fun getItemCount(): Int = seats.size

    class SeatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(context: Context, seat: Seat, onSeatClick: (Seat) -> Unit) {
            val seatButton: ImageButton = itemView.findViewById(R.id.btn_seat)
            val seatNumberText: TextView = itemView.findViewById(R.id.tv_seat_num)

            seatButton.isEnabled = seat.isAvailable // 클릭 가능 여부 설정

            when {
                !seat.isInitiallyAvailable -> {
                    // 예약 불가능한 좌석
                    seatButton.setImageResource(R.drawable.seat_unenabled)
                    seatNumberText.text = ""
                }
                seat.isSelected -> {
                    // 선택된 좌석
                    seatButton.setImageResource(R.drawable.seat_selected)
                    seatNumberText.text = seat.seatNumber
                    seatNumberText.setTextColor(ContextCompat.getColor(context, R.color.white))
                }
                !seat.isAvailable && seat.isInitiallyAvailable -> {
                    // 일시적으로 클릭할 수 없는 좌석
                    seatButton.setImageResource(R.drawable.seat_not_selected)
                    seatNumberText.text = ""
                }
                else -> {
                    // 예약 가능하지만 선택되지 않은 좌석
                    seatButton.setImageResource(R.drawable.seat_enabled)
                    seatNumberText.text = seat.seatNumber
                    seatNumberText.setTextColor(ContextCompat.getColor(context, R.color.black))
                }
            }

            itemView.setOnClickListener {
                if (seat.isAvailable) onSeatClick(seat)
            }
        }
    }

}
