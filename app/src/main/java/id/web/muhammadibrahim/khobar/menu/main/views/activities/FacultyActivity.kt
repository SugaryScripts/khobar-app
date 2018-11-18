package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityFacultyBinding
import id.web.muhammadibrahim.khobar.menu.faculty.views.activities.EducationActivity
import id.web.muhammadibrahim.khobar.menu.main.adapters.FacultyNDepartmentAdapter
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FacultyNDepartmentViewModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class FacultyActivity : AppCompatActivity(), FacultyNDepartmentAdapter.FacultyDepartmentClickListener {

    private lateinit var binding: ActivityFacultyBinding
    private lateinit var viewModelNDepartment: FacultyNDepartmentViewModel

    private lateinit var adapterFaculty: FacultyNDepartmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupToolbar()
        setupRecycler()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_faculty)
        viewModelNDepartment =
                ViewModelProviders.of(this).get(FacultyNDepartmentViewModel::class.java)
        viewModelNDepartment.facultyModel.observe(this, Observer {
            adapterFaculty.setItemFacultyDepartment(it)
        })
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarFacultyAct)
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(R.drawable.ic_left_balck)
        }
    }

    private fun setupRecycler() {
        adapterFaculty = FacultyNDepartmentAdapter(this)
        binding.rvFacultyFragFaculty.apply {
            adapter = adapterFaculty
            layoutManager = LinearLayoutManager(this@FacultyActivity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }

    override fun onClickFacultyDepartmentItem(model: FacultyNDepartmentModel) {
        if (model.title == "Education") startActivity(Intent(this, EducationActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home       -> finish()
            R.id.navigation_profile -> { }// todo: waiting design
        }
        return super.onOptionsItemSelected(item)
    }
}