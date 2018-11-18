package id.web.muhammadibrahim.khobar.menu.faculty.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.menu.faculty.viewmodels.EducationLecturerViewModel

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentEducationLecturerBinding
import id.web.muhammadibrahim.khobar.menu.faculty.adapters.EducationLecturerAdapter
import id.web.muhammadibrahim.khobar.menu.faculty.models.LecturerModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class EducationLecturerFragment : Fragment(), EducationLecturerAdapter.LecturerClickListener {

    companion object {
        fun newInstance() = EducationLecturerFragment()
    }

    private lateinit var binding: FragmentEducationLecturerBinding
    private lateinit var viewModel: EducationLecturerViewModel

    private lateinit var adapterLecturer: EducationLecturerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_education_lecturer, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EducationLecturerViewModel::class.java)
        viewModel.lecturerModel.observe(this, Observer {
            adapterLecturer.setLecturers(it)
        })
        setupRecycler()
    }

    private fun setupRecycler() {
        adapterLecturer = EducationLecturerAdapter(this)
        binding.rvLecturerEduFaculty.apply {
            adapter = adapterLecturer
            layoutManager = LinearLayoutManager(this@EducationLecturerFragment.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }

    override fun onClickLecturer(lecturer: LecturerModel) {
        Log.i("Education Lecturer","(^_^) Clicked item lecturer")
    }
}
