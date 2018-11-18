package id.web.muhammadibrahim.khobar.menu.faculty.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.menu.faculty.viewmodels.EducationDepartmentViewModel

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentEducationDepartmentBinding
import id.web.muhammadibrahim.khobar.menu.faculty.adapters.EducationDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.faculty.models.DepartmentModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class EducationDepartmentFragment : Fragment(), EducationDepartmentAdapter.EducationDepartmentClickListener {

    companion object {
        fun newInstance() = EducationDepartmentFragment()
    }

    private lateinit var binding: FragmentEducationDepartmentBinding
    private lateinit var viewModel: EducationDepartmentViewModel

    private lateinit var adapterDepartment: EducationDepartmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_education_department, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EducationDepartmentViewModel::class.java)
        viewModel.departmentModel.observe(this, Observer {
            adapterDepartment.setItemDepartment(it)
        })
        setupRecycler()
    }

    private fun setupRecycler() {
        adapterDepartment = EducationDepartmentAdapter(this)
        binding.rvDepartmentEduFaculty.apply {
            adapter = adapterDepartment
            layoutManager = LinearLayoutManager(this@EducationDepartmentFragment.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }

    override fun onClickFacultyDepartmentItem(model: DepartmentModel) {

    }
}
