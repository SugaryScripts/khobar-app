package id.web.muhammadibrahim.khobar.menu.faculty.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityEducationBinding
import id.web.muhammadibrahim.khobar.menu.faculty.views.BaseActivity
import id.web.muhammadibrahim.khobar.menu.faculty.adapters.EducationPagerAdapter
import android.support.v4.view.ViewPager
import id.web.muhammadibrahim.khobar.menu.faculty.views.fragments.EducationDepartmentFragment
import id.web.muhammadibrahim.khobar.menu.faculty.views.fragments.EducationLecturerFragment
import id.web.muhammadibrahim.khobar.menu.faculty.views.fragments.EducationVisionMissionFragment


class EducationActivity : BaseActivity() {

    private lateinit var binding: ActivityEducationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_education)
        setupToolbar(binding.toolbarEduFaculty,binding.tvTitleEduFaculty,"Education")

        setupViewPager(binding.viewpagerEduFaculty)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = EducationPagerAdapter(supportFragmentManager)
        adapter.addFragment(EducationVisionMissionFragment(), "Vision Mission")
        adapter.addFragment(EducationLecturerFragment(), "Lecturer")
        adapter.addFragment(EducationDepartmentFragment(), "Department")
        viewPager.adapter = adapter
        binding.tabsEduFaculty.setupWithViewPager(viewPager)
    }
}
