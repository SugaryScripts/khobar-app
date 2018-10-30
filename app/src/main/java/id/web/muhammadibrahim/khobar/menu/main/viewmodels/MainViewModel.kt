package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.HomeFragment

class MainViewModel(private val fragmentManager: FragmentManager, private val frame_containter: Int) {

    init {
        loadFragment(HomeFragment())
    }

    fun loadFragment(fragment: Fragment) {
        Log.i("(^_^)","current Fragment = "+fragmentManager.findFragmentById(frame_containter).toString())
        Log.i("(^_^)","input fragment = "+fragment.toString())
        if (fragmentManager.findFragmentById(frame_containter) != fragment ){
            // todo: fix multiple fragment
            Log.i("(^_^)","current fragment and target is different so change!")
                fragmentManager.beginTransaction()
                    .replace(frame_containter, fragment)
                    .commit()
        }else {
            Log.i("(^_^)","The fragment is not change!!")
        }
    }
}