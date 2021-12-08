package study.berezina.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_IMAGE = "image"

class AlphabetFragment : Fragment() {

    private lateinit var diceImageView: ImageView
    private lateinit var rollButton: Button
    private val diceImageList: List<Int> = listOf(

        R.drawable.picture1,
        R.drawable.picture2,
        R.drawable.picture3,
        R.drawable.picture4,
    )
    private var lastRolledImageRes = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)
        diceImageView = view.findViewById(R.id.dice_image)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            diceImageView.setImageResource(savedInstanceState.getInt(LAST_IMAGE))
        rollButton.setOnClickListener {
            lastRolledImageRes = diceImageList.random()
            diceImageView.setImageResource(lastRolledImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_IMAGE, lastRolledImageRes)

    }

}