package id.web.muhammadibrahim.khobar.menu.university.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityVideoProfileBinding
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityVisionMisionBinding

import kotlinx.android.synthetic.main.activity_university_vision_mision.*

class VisionMissionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityVisionMisionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_university_vision_mision)
    }

}
