package id.web.muhammadibrahim.myindago.menu.main.views.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ActivityMoreEventBinding
import id.web.muhammadibrahim.myindago.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentHomeViewModel

class MoreEventActivity : AppCompatActivity(), EventClickListener {

    lateinit var binding: ActivityMoreEventBinding
    lateinit var viewModel: FragmentHomeViewModel

    //lateinit var adapterEvent: EventMoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        //setupRecycler()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_event)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
    }

    fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    /*fun setupRecycler() {
        adapterEvent = EventMoreAdapter(this)
        viewModel.eventModel.observe(this, Observer {
            adapterEvent.setEvents(it)
        })
        binding.contentMOREEVENT.rvMoreEvent.apply {
            adapter = adapterEvent
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }*/

    override fun onClickEvent(eventModel: EventModel) {
        Toast.makeText(this,"clicked ${eventModel.title}", Toast.LENGTH_SHORT).show()
    }
}
