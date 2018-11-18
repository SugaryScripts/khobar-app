package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.MenuItem
import android.view.View
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityDetailBookBinding
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemBookViewModel
import id.web.muhammadibrahim.khobar.utility.ActivityHelper.Companion.handleToolbarTitleVisibility

class DetailBookActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    companion object {
        const val EXTRA_BOOK = "extra_book_id"
        @JvmStatic
        fun newIntent(context: Context, model: BookModel): Intent {
            val intent = Intent(context, DetailBookActivity::class.java)
            intent.putExtra(EXTRA_BOOK, model)
            return intent
        }
    }

    private lateinit var binding: ActivityDetailBookBinding
    private lateinit var viewmodel: ItemBookViewModel

    private var isTitleVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupToolbar()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_book)
        viewmodel = ItemBookViewModel(intent.getParcelableExtra(EXTRA_BOOK))
        binding.book = viewmodel
        binding.titleToolbarDetailBook.visibility = View.INVISIBLE
        binding.appbarDetailBook.addOnOffsetChangedListener(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetailBook)
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(R.drawable.ic_left_balck)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home       -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
        val maxScroll = appBarLayout.getTotalScrollRange()
        val percentage: Float = Math.abs(offset) / maxScroll.toFloat()
        isTitleVisible = handleToolbarTitleVisibility(binding.titleToolbarDetailBook,percentage,isTitleVisible)
    }
}
