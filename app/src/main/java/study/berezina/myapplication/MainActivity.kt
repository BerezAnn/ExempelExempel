package study.berezina.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAS_SELECTED_ITEM = "item"
private val DICE_ROLL_FRAGMENT = AlphabetFragment().javaClass.name
private val ABOUT_FRAGMENT = NumbersFragment().javaClass.name

class MainActivity : AppCompatActivity() {

 private   lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null
            when (item.itemId) {

                R.id.dice_roll -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        DICE_ROLL_FRAGMENT
                    )
                    else AlphabetFragment()

                }
                R.id.about_roll -> {

                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        ABOUT_FRAGMENT
                    )
                    else NumbersFragment()
                }
            }
            repliesFragment(fragment!!)
            true
        }
        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(
                LAS_SELECTED_ITEM
            ) ?: R.id.dice_roll


    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.putInt(LAS_SELECTED_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )
    }


    private fun repliesFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


}