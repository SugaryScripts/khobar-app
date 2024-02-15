package id.web.muhammadibrahim.khobar.menu.faculty.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.menu.faculty.viewmodels.EducationVisionMissionViewModel

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentEducationVisionMissionBinding

class EducationVisionMissionFragment : Fragment() {

    companion object {
        fun newInstance() = EducationVisionMissionFragment()
    }

    private lateinit var viewModel: EducationVisionMissionViewModel
    private lateinit var binding: FragmentEducationVisionMissionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_education_vision_mission, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EducationVisionMissionViewModel::class.java)
    }

}
