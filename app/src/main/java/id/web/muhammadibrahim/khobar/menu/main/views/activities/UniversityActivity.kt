package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityBinding
import id.web.muhammadibrahim.khobar.menu.university.views.activities.*

class UniversityActivity : AppCompatActivity() {

    lateinit var binding: ActivityUniversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_university)
        setupActionBar()
        setClick()
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

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_left_balck)
        }
    }

    private fun setClick() {
        binding.CharacteristicsUniversityAct.setOnClickListener { startActivity(Intent(this,CharacteristicsActivity::class.java)) }
        binding.aboutUniversityAct.setOnClickListener { startActivity(Intent(this,AboutActivity::class.java)) }
        binding.historyUniversityAct.setOnClickListener { startActivity(Intent(this,HistoryActivity::class.java)) }
        binding.recognationUniversityAct.setOnClickListener { startActivity(Intent(this,RecognitionActivity::class.java)) }
        binding.videoProfileUniversityAct.setOnClickListener { startActivity(Intent(this,VideoProfileActivity::class.java)) }
        binding.visionMissionUniversityAct.setOnClickListener { startActivity(Intent(this,VisionMissionActivity::class.java)) }
    }

}
