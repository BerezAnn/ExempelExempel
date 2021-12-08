package study.berezina.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeveloperViewHolden(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val developerNameTextView: TextView =
        itemView.findViewById(R.id.developers_name_text_view)

    fun bind(name: String) {
        developerNameTextView.text = name


    }
}