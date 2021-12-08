package study.berezina.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DeveloperAdapter(private val developerName: List<String>) :
    RecyclerView.Adapter<DeveloperViewHolden>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperViewHolden {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.deweloper_list_altem, parent, false)
        return DeveloperViewHolden(itemView)


    }

    override fun onBindViewHolder(holder: DeveloperViewHolden, position: Int) {
        val name = developerName[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return developerName.size
    }

}