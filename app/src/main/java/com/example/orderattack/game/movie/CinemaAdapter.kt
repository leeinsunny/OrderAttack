package com.example.orderattack.game.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R

class CinemaAdapter(private val cinemas: List<CinemaItem>, private val onClick: (CinemaItem) -> Unit)
    : RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>() {

    class CinemaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cinemaNameTextView: TextView = view.findViewById(R.id.cinemaName)
        private val selectButton: Button = view.findViewById(R.id.cinemaBtn)
        val imgTouch: ImageView = view.findViewById(R.id.img_touch)

        fun bind(cinema: CinemaItem, onClick: (CinemaItem) -> Unit) {
            cinemaNameTextView.text = cinema.cinemaName
            selectButton.setOnClickListener { onClick(cinema) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cinema_item_layout, parent, false)
        return CinemaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.bind(cinemas[position], onClick)
        val cinema = cinemas[position]
        if (cinema.cinemaName == "노원") {
            holder.imgTouch.visibility = View.VISIBLE
        } else {
            holder.imgTouch.visibility = View.GONE
        }
    }

    override fun getItemCount() = cinemas.size
}