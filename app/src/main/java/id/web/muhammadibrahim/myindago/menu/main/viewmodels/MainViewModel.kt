package id.web.muhammadibrahim.myindago.menu.main.viewmodels

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import id.web.muhammadibrahim.myindago.menu.main.views.fragments.HomeFragment

class MainViewModel(private val fragmentManager: FragmentManager, private val frame_containter: Int) {

    init {
        loadFragment(HomeFragment())
    }

    fun loadFragment(fragment: Fragment) {
        if (fragment != fragmentManager.findFragmentById(frame_containter)){
            // load fragment
            fragmentManager.beginTransaction()
                .replace(frame_containter, fragment)
                .commit()
        }
    }
}