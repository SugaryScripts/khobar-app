package id.web.muhammadibrahim.myindago.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.FragmentHomeBinding
import id.web.muhammadibrahim.myindago.menu.main.adapters.EventAdapter
import id.web.muhammadibrahim.myindago.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentHomeViewModel
import kotlinx.android.synthetic.main.layout_home_info.view.*

class FragmentHome : Fragment(), EventClickListener {

    companion object {
        fun newInstance() = FragmentHome()
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: FragmentHomeViewModel
    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        eventAdapter = EventAdapter(this)
        binding.includeEventFragHOME.rvEventFragHOME
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.eventModel.observe(this, Observer {
            eventAdapter.setEvents(it)
        })
        binding.includeEventFragHOME.rvEventFragHOME.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(this@FragmentHome.context, LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    override fun onClickEvent(eventModel: EventModel) {
        Toast.makeText(this.context,"clicked ${eventModel.title}",Toast.LENGTH_SHORT).show()
    }
}
