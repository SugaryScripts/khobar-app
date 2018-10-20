package id.web.muhammadibrahim.myindago.menu.main.views.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
