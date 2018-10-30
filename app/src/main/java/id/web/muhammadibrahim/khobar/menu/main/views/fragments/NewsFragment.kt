package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentNewsBinding
import id.web.muhammadibrahim.khobar.menu.main.adapters.NewsAdapter
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.FragmentHomeViewModel
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity
import id.web.muhammadibrahim.khobar.utility.MyDividerItemDecoration
import id.web.muhammadibrahim.khobar.utility.binding.Converters

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewModel: FragmentHomeViewModel

    private lateinit var adapterNews: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        adapterNews = NewsAdapter(((activity as AppCompatActivity) as MainActivity), true)
        viewModel.newsModel.observe(this, Observer {
            Converters.loadImage(binding.ivHeadimageMoreNews,it!![0].img_url)
            binding.tvTitleMoreNews.text = it[0].title
            binding.tvDateMoreNews.text = it[0].date
            binding.tvCategoryMoreNews.text = it[0].category
            Converters.loadBackgroundCategory(binding.tvDateMoreNews,it[0].category)
            adapterNews.setNews(it)
        })
        setupRecycler()
    }

    fun setupRecycler() {
        binding.rvContentEventMore.apply {
            adapter = adapterNews
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                MyDividerItemDecoration(
                    this.context,
                    DividerItemDecoration.VERTICAL,
                    0
                )
            )
            itemAnimator = DefaultItemAnimator(); hasFixedSize()
        }
    }
}
