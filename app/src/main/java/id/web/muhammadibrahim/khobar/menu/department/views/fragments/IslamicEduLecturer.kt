package id.web.muhammadibrahim.khobar.menu.department.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.databinding.FragmentIslamicEduLecturerBinding
import id.web.muhammadibrahim.khobar.menu.department.viewmodels.IslamicEduLecturerViewModel
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.menu.department.adapters.IslamicEduLecturerAdapter
import id.web.muhammadibrahim.khobar.menu.department.models.LecturerModel
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration

class IslamicEduLecturer : Fragment(), IslamicEduLecturerAdapter.LecturerClickListener {

    companion object {
        fun newInstance() = IslamicEduLecturer()
    }

    private lateinit var binding: FragmentIslamicEduLecturerBinding
    private lateinit var viewModel: IslamicEduLecturerViewModel

    private lateinit var adapterLecturer: IslamicEduLecturerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_islamic_edu_lecturer, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IslamicEduLecturerViewModel::class.java)
        viewModel.lecturerModel.observe(this, Observer {
            adapterLecturer.setLecturers(it)
        })
        setupRecycler()
    }

    private fun setupRecycler(){
        adapterLecturer = IslamicEduLecturerAdapter(this)
        binding.rvLecturerIslamicEduDepart.apply {
            adapter = adapterLecturer
            layoutManager = LinearLayoutManager(this@IslamicEduLecturer.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
        }
    }

    override fun onClickLecturer(lecturer: LecturerModel) {
        Log.i("Islamic Edu Lecturer","(^_^) Clicked item lecturer")
    }
}
