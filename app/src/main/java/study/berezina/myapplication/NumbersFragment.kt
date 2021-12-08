package study.berezina.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NumbersFragment : Fragment() {
   private lateinit var developersRecyclerView: RecyclerView
    private lateinit var showWebBottom: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_numbers, container, false)

        val developerName: List<String> = listOf(
            "Пушкин А.С.",
            "У лукоморья дуб зелёный;\n" +
                    "Златая цепь на дубе том:\n" +
                    "И днём и ночью кот учёный\n" +
                    "Всё ходит по цепи кругом;\n" +
                    "Идёт направо — песнь заводит,\n" +
                    "Налево — сказку говорит.\n ")

        showWebBottom = view.findViewById(R.id.web_bottom)
        developersRecyclerView = view.findViewById(R.id.developers_recycler_view)
        developersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter = DeveloperAdapter(developerName)
        showWebBottom.setOnClickListener {
            val link = Uri.parse("http://google.com/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)

        }


        return view
    }

}