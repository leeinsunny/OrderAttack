import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderattack.R
import com.example.orderattack.game.movie.TimeItem


interface OnShowtimeClickListener {
    fun onShowtimeClicked(timeId: Int)
}

class ShowtimesAdapter(private val showtimesList: List<TimeItem>,
                       private val listener: OnShowtimeClickListener
) : RecyclerView.Adapter<ShowtimesAdapter.ShowtimeViewHolder>() {

    class ShowtimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeButton: ImageView = itemView.findViewById(R.id.timeBtn)
        val imgTouch: ImageView = itemView.findViewById(R.id.img_touch)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowtimeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.showtime_item_layout, parent, false)
        return ShowtimeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShowtimeViewHolder, position: Int) {
        val timeItem = showtimesList[position]
        holder.timeButton.setImageResource(timeItem.imageResId)

        holder.itemView.setOnClickListener {
            // 콜백을 통해 클릭된 imageResId 전달
            listener.onShowtimeClicked(timeItem.timeId)
        }

        if (timeItem.timeId == 2) {
            holder.imgTouch.visibility = View.VISIBLE
        } else {
            holder.imgTouch.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = showtimesList.size

}