package com.mobishop.toplixe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobishop.toplixe.R
import com.mobishop.toplixe.common.Const.Companion.doubleBackToExitPressed
import com.mobishop.toplixe.fragment.film.FilmFragment
import com.mobishop.toplixe.fragment.home.HomeFragment
import com.mobishop.toplixe.fragment.song.SongFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navBottom.setOnNavigationItemSelectedListener(this)
        navBottom.menu.getItem(1).isChecked = true
        loadFragment(HomeFragment()) //load fragment in mainActivity
    }
    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivity, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment?
        fragment = when (item.itemId) {
            R.id.item_home -> {
                HomeFragment()
            }
            R.id.item_music -> {
                SongFragment()
            }
            R.id.item_film -> {
                FilmFragment()
            }

            else -> HomeFragment()
        }
        return loadFragment(fragment)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressed) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressed = true
        Toast.makeText(this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressed = false }, 2000)
    }
}