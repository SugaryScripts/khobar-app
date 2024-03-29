package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentHomeBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.khobar.menu.main.adapters.NewsAdapter
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FragmentHomeViewModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import id.web.muhammadibrahim.khobar.menu.main.views.activities.UniversityActivity
import id.web.muhammadibrahim.khobar.menu.main.views.activities.FacultyActivity
import id.web.muhammadibrahim.khobar.menu.main.views.activities.LibraryActivity
import id.web.muhammadibrahim.khobar.menu.main.views.activities.DepartmentActivity
import kotlinx.android.synthetic.main.layout_home_info.view.*


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: FragmentHomeViewModel
    private lateinit var eventAdapter: EventAdapter
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        ((activity as AppCompatActivity) as MainActivity).setupToolbar("Home")
        setupRecyclerView()
        setupClickedView()
    }

    fun setupRecyclerView() {
        // setup for Event RecyclerView
        eventAdapter = EventAdapter(((activity as AppCompatActivity) as MainActivity), false)
        viewModel.eventModel.observe(this, Observer {
            eventAdapter.setEvents(it)
        })
        binding.includeEventFragHOME.rvEventFragHOME.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.context, LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }

        // setup for News RecyclerView
        newsAdapter = NewsAdapter(((activity as AppCompatActivity) as MainActivity), false)
        viewModel.newsModel.observe(this, Observer {
            newsAdapter.setNews(it)
        })
        binding.includeNewsFragHOME.rvNewsFragHOME.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(MyDividerItemDecoration(this@HomeFragment.context, DividerItemDecoration.VERTICAL, 0))
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    private fun setupClickedView() {
        binding.includeInfoFragHOME.library_info.setOnClickListener { startActivity(Intent(activity, LibraryActivity::class.java)) }
        binding.includeInfoFragHOME.department_info.setOnClickListener { startActivity(Intent(activity, DepartmentActivity::class.java)) }
        binding.includeInfoFragHOME.faculty_info.setOnClickListener { startActivity(Intent(activity, FacultyActivity::class.java)) }
        binding.includeInfoFragHOME.university_info.setOnClickListener { startActivity(Intent(activity,UniversityActivity::class.java)) }
        binding.includeEventFragHOME.tvMoreEventFragHOME.setOnClickListener {
            ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().selectedItemId = R.id.navigation_event
        }
        binding.includeNewsFragHOME.tvMoreNewsFragHOME.setOnClickListener {
            ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().selectedItemId = R.id.navigation_news
        }
    }
}
