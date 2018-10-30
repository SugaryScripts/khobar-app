package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityMainBinding
import id.web.muhammadibrahim.khobar.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.khobar.menu.main.interfaces.NewsClickListener
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.MainViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.EventFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.HomeFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), NewsClickListener, EventClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding()
        setupToolbar()
        setupBottomNavigation()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = MainViewModel(supportFragmentManager, binding.flContentMAIN.id)
        binding.viewModel = viewmodel
    }

    fun setupToolbar(title: String) {
        binding.titleToolbar.text = title
        val home = title == "Home"
        if (!home) {
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_left_balck)
            binding.searchToolbar.visibility = View.VISIBLE
        }else binding.searchToolbar.visibility = View.GONE
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(!home)
            setDisplayShowHomeEnabled(!home)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home       -> binding.navigation.selectedItemId = R.id.navigation_home
            R.id.navigation_profile -> { }// todo: waiting design
        }
        return super.onOptionsItemSelected(item)
    }

    fun getBottomNavigation(): BottomNavigationView = binding.navigation

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

    override fun onClickNews(newsModel: NewsModel) {
        startActivity(DetailNewsActivity.newIntent(this,newsModel))
    }

    override fun onClickEvent(eventModel: EventModel) {
        startActivity(DetailEventActivity.newIntent(this,eventModel))
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentById(binding.flContentMAIN.id) is HomeFragment) {
            Log.i("(^_^)", "On else so it's finish")
            super.onBackPressed()
        } else {
            Log.i("(^_^)", "It is home fragment so it still alive")
            binding.navigation.selectedItemId = R.id.navigation_home
                if (binding.navigation.visibility == View.GONE) binding.navigation.visibility = View.VISIBLE
        }
    }
}
