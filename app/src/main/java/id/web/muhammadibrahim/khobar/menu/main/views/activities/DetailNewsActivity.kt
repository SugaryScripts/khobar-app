package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.View
import android.view.animation.AlphaAnimation
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ActivityDetailNewsBinding
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemNewsViewModel

class DetailNewsActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

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

    private val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
    private val ALPHA_ANIMATIONS_DURATION: Long = 200
    private var mIsTheTitleVisible = false

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
        binding.titleToolbarDetailNews.visibility = View.INVISIBLE
        binding.appbarDetailNews.addOnOffsetChangedListener(this)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
        val maxScroll = appBarLayout.getTotalScrollRange()
        val percentage: Float = Math.abs(offset) / maxScroll.toFloat()
        handleToolbarTitleVisibility(percentage)
    }

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(binding.titleToolbarDetailNews, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
                mIsTheTitleVisible = true
            }

        } else {
            if (mIsTheTitleVisible) {
                startAlphaAnimation(binding.titleToolbarDetailNews, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
                mIsTheTitleVisible = false
            }
        }
    }

    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val alphaAnimation = if (visibility == View.VISIBLE)
            AlphaAnimation(0f, 1f)
        else
            AlphaAnimation(1f, 0f)

        alphaAnimation.duration = duration
        alphaAnimation.fillAfter = true
        v.startAnimation(alphaAnimation)
    }
}
