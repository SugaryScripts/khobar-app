package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.EventViewModel

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentEventBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.khobar.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FragmentHomeViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import android.support.design.widget.AppBarLayout
import android.util.Log
import android.view.*
import id.web.muhammadibrahim.khobar.R.id.toolbar



class EventFragment : Fragment() {

    companion object {
        fun newInstance() = EventFragment()
    }

    private lateinit var viewModel: FragmentHomeViewModel
    private lateinit var binding: FragmentEventBinding

    private lateinit var adapterEvent: EventAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_event, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapterEvent = EventAdapter(((activity as AppCompatActivity) as MainActivity), true)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        viewModel.eventModel.observe(this, Observer {
            adapterEvent.setEvents(it)
        })
        ((activity as AppCompatActivity) as MainActivity).setupToolbar("Event")
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rvContentEventMore.apply {
            adapter = adapterEvent
            layoutManager = LinearLayoutManager(this@EventFragment.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }
}
