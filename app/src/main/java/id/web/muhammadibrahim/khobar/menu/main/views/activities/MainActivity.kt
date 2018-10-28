package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityMainBinding
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.MainViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.EventFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.HomeFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding()
        setupBottomNavigation()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = MainViewModel(supportFragmentManager, binding.flContentMAIN.id)
        binding.viewModel = viewmodel
    }

    private fun setupBottomNavigation() {
        binding.navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    viewmodel.loadFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_event -> {
                    viewmodel.loadFragment(EventFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_news -> {
                    viewmodel.loadFragment(NewsFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false }
        )
    }
}