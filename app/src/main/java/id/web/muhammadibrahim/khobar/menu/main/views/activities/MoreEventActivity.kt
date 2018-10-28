package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityMoreEventBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.khobar.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FragmentHomeViewModel

class MoreEventActivity : AppCompatActivity(), EventClickListener {

    lateinit var binding: ActivityMoreEventBinding
    lateinit var viewModel: FragmentHomeViewModel

    lateinit var adapterEvent: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_event)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        viewModel.eventModel.observe(this, Observer {
            adapterEvent.setEvents(it)
        })
    }

    fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.apply {
            setDisplayShowTitleEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    fun setupRecycler() {
        adapterEvent = EventAdapter(this, true)
        binding.rvContentEventMore.apply {
            adapter = adapterEvent
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    override fun onClickEvent(eventModel: EventModel) {
        startActivity(DetailEventActivity.newIntent(this,eventModel))
    }
}
