package id.web.muhammadibrahim.khobar.menu.university.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityUniversityRecognitionBinding
import id.web.muhammadibrahim.khobar.menu.university.adapters.RecognitionAdapter
import id.web.muhammadibrahim.khobar.menu.university.models.RecognitionModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration
import id.web.muhammadibrahim.khobar.menu.university.viewmodels.RecognitionViewModel

class RecognitionActivity : AppCompatActivity(), RecognitionAdapter.RecognitionClickListener {

    lateinit var binding: ActivityUniversityRecognitionBinding
    lateinit var viewModel: RecognitionViewModel

    private lateinit var adapterRecognition: RecognitionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupRecyclerView()
    }

    override fun onClickRecognition(recognitionModel: RecognitionModel) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setupRecyclerView() {
        adapterRecognition = RecognitionAdapter(this)
        binding.rvRecognitionRecogUni.apply {
            adapter = adapterRecognition
            layoutManager = LinearLayoutManager(
                this@RecognitionActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            addItemDecoration(
                MyDividerItemDecoration(
                    this@RecognitionActivity,
                    DividerItemDecoration.VERTICAL,
                    0
                )
            )
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_university_recognition)
        viewModel = ViewModelProviders.of(this).get(RecognitionViewModel::class.java)
        viewModel.recognitionModel.observe(this, Observer {
            adapterRecognition.setData(it)
        })
    }

}