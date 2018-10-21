package id.web.muhammadibrahim.myindago.menu.main.viewmodels

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import id.web.muhammadibrahim.myindago.menu.main.views.fragments.FragmentHome

class MainViewModel(private val fragmentManager: FragmentManager, private val frame_containter: Int) {

    init {
        loadFragment(FragmentHome())
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