package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.web.muhammadibrahim.khobar.R
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.design.widget.AppBarLayout
import android.view.View
import id.web.muhammadibrahim.khobar.databinding.ActivityDetailEventBinding
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemEventViewModel
import android.view.animation.AlphaAnimation




class DetailEventActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    companion object {
        const val EXTRA_EVENT = "extra_event_id"
        @JvmStatic
        fun newIntent(context: Context, model: EventModel): Intent {
            val intent = Intent(context, DetailEventActivity::class.java)
            intent.putExtra(EXTRA_EVENT, model)
            return intent
        }
    }

    lateinit var binding: ActivityDetailEventBinding
    lateinit var viewModel: ItemEventViewModel
    lateinit var eventModel: EventModel

    private val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
    private val ALPHA_ANIMATIONS_DURATION: Long = 200
    private var mIsTheTitleVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
    }

    fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_event)
        intent.extras.let {
            eventModel = intent.getParcelableExtra(EXTRA_EVENT)
        }
        viewModel = ItemEventViewModel(eventModel)
        binding.detailEvent = viewModel
        binding.titleToolbarDetailEvent.visibility = View.INVISIBLE
        binding.appbarDetailEvent.addOnOffsetChangedListener(this)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
        val maxScroll = appBarLayout.getTotalScrollRange()
        val percentage: Float = Math.abs(offset) / maxScroll.toFloat()
        handleToolbarTitleVisibility(percentage)
    }

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                        startAlphaAnimation(binding.titleToolbarDetailEvent, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
                mIsTheTitleVisible = true
            }

        } else {
            if (mIsTheTitleVisible) {
                startAlphaAnimation(binding.titleToolbarDetailEvent, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
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
