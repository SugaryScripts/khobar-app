package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityDepartmentBinding
import id.web.muhammadibrahim.khobar.menu.department.views.activities.IslamicEducationActivity
import id.web.muhammadibrahim.khobar.menu.faculty.views.activities.EducationActivity
import id.web.muhammadibrahim.khobar.menu.main.adapters.FacultyNDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FacultyNDepartmentViewModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class DepartmentActivity : AppCompatActivity(), FacultyNDepartmentAdapter.FacultyDepartmentClickListener {

    private lateinit var binding: ActivityDepartmentBinding
    private lateinit var viewModelNDepartment: FacultyNDepartmentViewModel

    private lateinit var adapterDepartment: FacultyNDepartmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupRecycler()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_department)
        viewModelNDepartment = ViewModelProviders.of(this).get(FacultyNDepartmentViewModel::class.java)
        viewModelNDepartment.departmentModel.observe(this, Observer {
            adapterDepartment.setItemFacultyDepartment(it)
        })
    }

    private fun setupRecycler(){
        adapterDepartment = FacultyNDepartmentAdapter(this)
        binding.rvDepartmentDepartment.apply {
            adapter = adapterDepartment
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }

    override fun onClickFacultyDepartmentItem(model: FacultyNDepartmentModel) {
        if (model.title == "Education") startActivity(Intent(this, EducationActivity::class.java))
        if (model.title == "Islamic Education") startActivity(Intent(this, IslamicEducationActivity::class.java))
    }
}