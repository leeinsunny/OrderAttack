package com.example.orderattack.game.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R

interface OnDateClickListener {
    fun onDateClicked(dateResId: Int)
}

class DatesAdapter(private val dateList: List<DateItem>,
                   private val listener: OnDateClickListener)
    : RecyclerView.Adapter<DatesAdapter.DateViewHolder>() {

    class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateImage: ImageView = itemView.findViewById(R.id.dateImage)
        val imgTouch: ImageView = itemView.findViewById(R.id.img_touch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.date_item_layout, parent, false)
        return DateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val dateItem = dateList[position]

        // 초기 이미지 설정
        holder.dateImage.setImageResource(if (dateItem.isClicked) dateItem.clickedImageResId else dateItem.imageResId)

        if (dateItem.id == "2") {
            holder.imgTouch.visibility = View.VISIBLE
        } else {
            holder.imgTouch.visibility = View.GONE
        }

        // 클릭 리스너 설정
        holder.dateImage.setOnClickListener {
            // 이미 클릭되어 있는지 체크
            if (dateItem.isClicked) return@setOnClickListener

            // 새로운 버튼만 클릭
            dateItem.isClicked = true

            // 클릭 리스너
            listener.onDateClicked(dateItem.clickedImageResId)


            holder.dateImage.setImageResource(dateItem.clickedImageResId)

            // 나머지 버튼은 초기화
            dateList.forEachIndexed { index, item ->
                if (index != position) {
                    item.isClicked = false
                }
            }

            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = dateList.size
}
