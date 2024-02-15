package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.HomeFragment

class MainViewModel(private val fragmentManager: FragmentManager, private val frame_containter: Int) {

    lateinit var selectedNavigation: String

    init {
        loadFragment(HomeFragment(), "Home")
    }

    fun loadFragment(fragment: Fragment, nameFragment: String) {
        selectedNavigation = nameFragment
        fragmentManager.beginTransaction()
            .replace(frame_containter, fragment)
            .commit()
    }
}