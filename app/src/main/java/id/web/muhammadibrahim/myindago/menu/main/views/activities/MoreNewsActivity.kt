package id.web.muhammadibrahim.myindago.menu.main.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ActivityMoreNewsBinding
import id.web.muhammadibrahim.myindago.menu.main.adapters.NewsAdapter
import id.web.muhammadibrahim.myindago.menu.main.interfaces.NewsClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.NewsModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentHomeViewModel
import id.web.muhammadibrahim.myindago.utility.binding.Converters
import id.web.muhammadibrahim.myindago.utility.MyDividerItemDecoration

class MoreNewsActivity : AppCompatActivity(), NewsClickListener {

    lateinit var binding: ActivityMoreNewsBinding
    lateinit var viewModel: FragmentHomeViewModel

    lateinit var adapterNews: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_news)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
    }

    fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.apply {
            setDisplayShowTitleEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    fun setupRecycler() {
        adapterNews = NewsAdapter(this,true)
        binding.rvContentEventMore.apply {
            adapter = adapterNews
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(MyDividerItemDecoration(this.context, DividerItemDecoration.VERTICAL, 0))
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }

        viewModel.newsModel.observe(this, Observer {
            Converters.loadImage(binding.ivHeadimageMoreNews,it!![0].img_url)
            binding.tvTitleMoreNews.text = it[0].title
            binding.tvDateMoreNews.text = it[0].date
            binding.tvCategoryMoreNews.text = it[0].category
            Converters.loadBackgroundCategory(binding.tvDateMoreNews,it[0].category)
            adapterNews.setNews(it)
        })
    }

    override fun onClickNews(newsModel: NewsModel) {
        startActivity(DetailNewsActivity.newIntent(this,newsModel))
    }
}
