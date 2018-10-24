package id.web.muhammadibrahim.myindago.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.FragmentHomeBinding
import id.web.muhammadibrahim.myindago.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.myindago.menu.main.adapters.NewsAdapter
import id.web.muhammadibrahim.myindago.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.myindago.menu.main.interfaces.NewsClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel
import id.web.muhammadibrahim.myindago.menu.main.models.NewsModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentHomeViewModel
import id.web.muhammadibrahim.myindago.menu.main.views.activities.MoreNewsActivity
import id.web.muhammadibrahim.myindago.utility.MyDividerItemDecoration

class FragmentHome : Fragment(), EventClickListener, NewsClickListener {

    companion object {
        fun newInstance() = FragmentHome()
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

        setupRecyclerView()
        setupClickedMore()
    }

    override fun onClickEvent(eventModel: EventModel) {
        Toast.makeText(this.context,"clicked ${eventModel.title}",Toast.LENGTH_SHORT).show()
    }

    override fun onClickNews(newsModel: NewsModel) {
        Toast.makeText(this.context,"clicked ${newsModel.title}",Toast.LENGTH_SHORT).show()
    }

    fun setupRecyclerView() {
        // setup for Event RecyclerView
        eventAdapter = EventAdapter(this)
        viewModel.eventModel.observe(this, Observer {
            eventAdapter.setEvents(it)
        })
        binding.includeEventFragHOME.rvEventFragHOME.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(this@FragmentHome.context, LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }

        // setup for News RecyclerView
        newsAdapter = NewsAdapter(this)
        viewModel.newsModel.observe(this, Observer {
            newsAdapter.setNews(it)
        })
        binding.includeNewsFragHOME.rvNewsFragHOME.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@FragmentHome.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(MyDividerItemDecoration(this@FragmentHome.context, DividerItemDecoration.VERTICAL, 0))
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    fun setupClickedMore() {
        binding.includeEventFragHOME.tvMoreEventFragHOME.setOnClickListener {

        }
        binding.includeNewsFragHOME.tvMoreNewsFragHOME.setOnClickListener {
            startActivity(Intent(this.context, MoreNewsActivity::class.java))
        }
    }
}
