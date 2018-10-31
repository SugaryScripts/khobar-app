package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.databinding.FragmentLibraryBinding
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FragmentLibraryViewModel
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.menu.main.adapters.LibraryAdapter
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import id.web.muhammadibrahim.khobar.utility.GridSpacingItemDecoration
import android.util.TypedValue



class LibraryFragment: Fragment(){

    companion object {
        fun newInstance() = LibraryFragment()
    }

    private lateinit var binding: FragmentLibraryBinding
    private lateinit var viewmodel: FragmentLibraryViewModel

    private lateinit var adapterLibrary: LibraryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_library, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapterLibrary = LibraryAdapter(((activity as AppCompatActivity) as MainActivity))
        viewmodel = ViewModelProviders.of(this).get(FragmentLibraryViewModel::class.java)
        viewmodel.libraryModel.observe(this, Observer {
            adapterLibrary.setBooks(it)
        })
        ((activity as AppCompatActivity) as MainActivity).setupToolbar("Library")
        ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().visibility = View.GONE
        setupRecycler()
    }

    fun setupRecycler() {
        binding.rvLibraryFragLibrary.apply {
            adapter = adapterLibrary

            layoutManager = GridLayoutManager(this@LibraryFragment.context, 2)
                    //LinearLayoutManager(this@LibraryFragment.context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(GridSpacingItemDecoration(2, dpToPx(16), true))
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }

    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}