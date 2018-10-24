package id.web.muhammadibrahim.myindago.menu.main.views.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ActivityMoreNewsBinding
import id.web.muhammadibrahim.myindago.menu.main.interfaces.NewsClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.NewsModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentHomeViewModel

class MoreNewsActivity : AppCompatActivity(), NewsClickListener {

    lateinit var binding: ActivityMoreNewsBinding
    lateinit var viewModel: FragmentHomeViewModel

    //lateinit var adapterNews: NewsMoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        //setupRecycler()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_news)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        /*viewModel.newsModel.observe(this, Observer {
            Converters.loadImage(binding.contentMORENEWS.ivHeadlineMoreNews,it!![0].img_url)
            binding.contentMORENEWS.tvTitleMoreNews.text = it[0].title
            binding.contentMORENEWS.tvDateMoreNews.text = it[0].date
            adapterNews.setNews(it)
        })*/
    }

    fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    /*fun setupRecycler() {
        adapterNews = NewsMoreAdapter(this)
        binding.contentMORENEWS.rvMoreNews.apply {
            adapter = adapterNews
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }*/

    override fun onClickNews(newsModel: NewsModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
