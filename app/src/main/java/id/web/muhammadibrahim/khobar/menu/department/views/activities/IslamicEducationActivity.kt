package id.web.muhammadibrahim.khobar.menu.department.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityIslamicEducationBinding
import id.web.muhammadibrahim.khobar.menu.department.adapters.IslamicEduPagerAdapter
import id.web.muhammadibrahim.khobar.menu.department.views.BaseActivity
import id.web.muhammadibrahim.khobar.menu.department.views.fragments.IslamicEduLecturer
import id.web.muhammadibrahim.khobar.menu.department.views.fragments.IslamicEduVisionMission

class IslamicEducationActivity : BaseActivity() {

    private lateinit var binding: ActivityIslamicEducationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_islamic_education)
        setupToolbar(binding.toolbarIslamicEduDepart,binding.tvTitleIslamicEduDepart,"Islamic Education")
        setupViewPager(binding.viewpagerIslamicEduDepart)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = IslamicEduPagerAdapter(supportFragmentManager)
        adapter.addFragment(IslamicEduVisionMission(), "Vision Mission")
        adapter.addFragment(IslamicEduLecturer(), "Lecturer")
        viewPager.adapter = adapter
        binding.tabsIslamicEduDepart.setupWithViewPager(viewPager)
    }
}
