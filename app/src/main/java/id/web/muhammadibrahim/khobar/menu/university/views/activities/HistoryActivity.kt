package id.web.muhammadibrahim.khobar.menu.university.views.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityHistoryBinding

import kotlinx.android.synthetic.main.activity_university_history.*

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_university_history)
    }

}
