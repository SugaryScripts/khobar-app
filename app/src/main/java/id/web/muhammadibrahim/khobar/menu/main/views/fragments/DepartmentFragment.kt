package id.web.muhammadibrahim.khobar.menu.main.views.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
import id.web.muhammadibrahim.khobar.databinding.FragmentDepartmentBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.FacultyNDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FacultyNDepartmentViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class DepartmentFragment : Fragment() {

    companion object {
        fun newInstance() = FacultyFragment()
    }

    private lateinit var binding: FragmentDepartmentBinding
    private lateinit var viewModelNDepartment: FacultyNDepartmentViewModel

    private lateinit var adapterDepartment: FacultyNDepartmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_department, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapterDepartment = FacultyNDepartmentAdapter(((activity as AppCompatActivity) as MainActivity))

        viewModelNDepartment = ViewModelProviders.of(this).get(FacultyNDepartmentViewModel::class.java)
        viewModelNDepartment.departmentModel.observe(this, Observer {
            adapterDepartment.setItemFacultyDepartment(it)
        })

        ((activity as AppCompatActivity) as MainActivity).setupToolbar("Department")
        ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().visibility = View.GONE

        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rvDepartmentFragDepartment.apply {
            adapter = adapterDepartment
            layoutManager = LinearLayoutManager(this@DepartmentFragment.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }
}
