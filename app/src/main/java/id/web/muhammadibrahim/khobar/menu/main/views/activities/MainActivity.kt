package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import io.fabric.sdk.android.Fabric
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityMainBinding
import id.web.muhammadibrahim.khobar.menu.department.views.activities.IslamicEducationActivity
import id.web.muhammadibrahim.khobar.menu.faculty.views.activities.EducationActivity
import id.web.muhammadibrahim.khobar.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.khobar.menu.main.adapters.FacultyNDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.main.adapters.LibraryAdapter
import id.web.muhammadibrahim.khobar.menu.main.adapters.NewsAdapter
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.MainViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.EventFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.HomeFragment
import id.web.muhammadibrahim.khobar.menu.main.views.fragments.NewsFragment

class MainActivity : AppCompatActivity(), NewsAdapter.NewsClickListener, EventAdapter.EventClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics(), Answers())

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
        val isHome = title == "Home"

        if (title == "Event" || title == "News" || title == "Library") binding.searchToolbar.visibility = View.VISIBLE
        else binding.searchToolbar.visibility = View.GONE

        if (!isHome) supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_left_balck)

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(!isHome)
            setDisplayShowHomeEnabled(!isHome)
        }
        /*fragmentManager.beginTransaction()
            .replace(frame_containter, fragment)
            .commit()*/

        /*var toolbar = binding.toolbar
        var params:AppBarLayout.LayoutParams = (toolbar.layoutParams as AppBarLayout.LayoutParams)
        when (title) {
            "About" -> params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL and AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED
            "Characteristic" -> params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL and AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
            "History" -> params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL and AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
            "Recognition" -> params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL and AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
            "Video Profile" ->params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL and AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS
        }*/
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
                    if (viewmodel.selectedNavigation != "Home") viewmodel.loadFragment(HomeFragment(), "Home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_event -> {
                    if (viewmodel.selectedNavigation != "Event") viewmodel.loadFragment(EventFragment(), "Event")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_news -> {
                    if (viewmodel.selectedNavigation != "News")viewmodel.loadFragment(NewsFragment(), "News")
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
