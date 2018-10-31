package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
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
import id.web.muhammadibrahim.khobar.databinding.FragmentFacultyBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.FacultyNDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FacultyNDepartmentViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class FacultyFragment : Fragment() {

    companion object {
        fun newInstance() = FacultyFragment()
    }

    private lateinit var binding: FragmentFacultyBinding
    private lateinit var viewModelNDepartment: FacultyNDepartmentViewModel

    private lateinit var adapterFaculty: FacultyNDepartmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faculty, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapterFaculty = FacultyNDepartmentAdapter(((activity as AppCompatActivity) as MainActivity))

        viewModelNDepartment = ViewModelProviders.of(this).get(FacultyNDepartmentViewModel::class.java)
        viewModelNDepartment.facultyModel.observe(this, Observer {
            adapterFaculty.setItemFacultyDepartment(it)
        })

        ((activity as AppCompatActivity) as MainActivity).setupToolbar("Faculty")
        ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().visibility = View.GONE

        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rvFacultyFragFaculty.apply {
            adapter = adapterFaculty
            layoutManager = LinearLayoutManager(this@FacultyFragment.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }
}
