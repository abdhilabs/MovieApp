package com.abdhilabs.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.abdhilabs.movieapp.movie.MovieFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    private val mOnNavigationItem = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.action_movie ->{
                val fragment = MovieFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun addFragment(fragment: Fragment) {

    }
}
