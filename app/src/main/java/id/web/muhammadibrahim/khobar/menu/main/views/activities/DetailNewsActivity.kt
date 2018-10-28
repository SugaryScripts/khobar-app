package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityDetailNewsBinding
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemNewsViewModel

class DetailNewsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NEWS = "extra_news"
        @JvmStatic
        fun newIntent(context: Context, model: NewsModel): Intent {
            val intent = Intent(context, DetailNewsActivity::class.java)
            intent.putExtra(EXTRA_NEWS, model)
            return intent
        }
    }

    lateinit var binding: ActivityDetailNewsBinding
    lateinit var viewModel: ItemNewsViewModel
    lateinit var newsModel: NewsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_news)
        intent.extras.let {
            newsModel = intent.getParcelableExtra(EXTRA_NEWS)
        }
        viewModel = ItemNewsViewModel(newsModel)
        binding.detailNews = viewModel
    }
}
