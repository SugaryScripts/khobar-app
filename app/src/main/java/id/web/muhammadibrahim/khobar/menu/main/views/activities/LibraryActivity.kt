package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityLibraryBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.LibraryAdapter
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.LibraryViewModel
import id.web.muhammadibrahim.khobar.utility.ActivityHelper.Companion.dpToPx
import id.web.muhammadibrahim.khobar.utility.GridSpacingItemDecoration

class LibraryActivity : AppCompatActivity(), LibraryAdapter.BookClickListener {

    private lateinit var binding: ActivityLibraryBinding
    private lateinit var viewmodel: LibraryViewModel

    private lateinit var adapterLibrary: LibraryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupToolbar()
        setupRecycler()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_library)
        viewmodel = ViewModelProviders.of(this).get(LibraryViewModel::class.java)
        viewmodel.bookModel.observe(this, Observer {
            adapterLibrary.setBooks(it)
        })
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(R.drawable.ic_left_balck)
        }
    }

    private fun setupRecycler() {
        adapterLibrary = LibraryAdapter(this)
        binding.rvLibraryFragLibrary.apply {
            adapter = adapterLibrary

            layoutManager = GridLayoutManager(this.context, 2)
            addItemDecoration(GridSpacingItemDecoration(2, dpToPx(16, this@LibraryActivity), true))
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
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

    override fun onClickBook(model: BookModel) {
        startActivity(DetailBookActivity.newIntent(this,model))
    }
}
