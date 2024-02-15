package id.web.muhammadibrahim.khobar.menu.university.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityVideoProfileBinding

class VideoProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityVideoProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_university_video_profile)
    }

}