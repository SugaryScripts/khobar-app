package id.web.muhammadibrahim.khobar.menu.university.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityAboutBinding
import id.web.muhammadibrahim.khobar.menu.university.viewmodels.AboutViewModel
import id.web.muhammadibrahim.khobar.menu.university.views.BaseActivity

class AboutActivity : BaseActivity() {

    lateinit var binding: ActivityUniversityAboutBinding
    lateinit var viewmodel: AboutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_university_about)
        viewmodel = AboutViewModel(resources.getString(R.string.dummy_text_long),resources.getString(R.string.dummy_image))
        binding.about = viewmodel
    }

}
