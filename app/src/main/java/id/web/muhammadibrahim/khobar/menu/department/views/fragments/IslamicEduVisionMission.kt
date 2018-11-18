package id.web.muhammadibrahim.khobar.menu.department.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.menu.department.viewmodels.IslamicEduVisionMissionViewModel

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentIslamicEduVisionMissionBinding

class IslamicEduVisionMission : Fragment() {

    companion object {
        fun newInstance() = IslamicEduVisionMission()
    }

    private lateinit var viewModel: IslamicEduVisionMissionViewModel
    private lateinit var binding: FragmentIslamicEduVisionMissionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_islamic_edu_vision_mission, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IslamicEduVisionMissionViewModel::class.java)
    }

}
