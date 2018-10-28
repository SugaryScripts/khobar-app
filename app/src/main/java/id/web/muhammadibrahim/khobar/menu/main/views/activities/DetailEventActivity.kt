package id.web.muhammadibrahim.khobar.menu.main.views.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.web.muhammadibrahim.khobar.R
import android.content.Intent
import android.databinding.DataBindingUtil
import id.web.muhammadibrahim.khobar.databinding.ActivityDetailEventBinding
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemEventViewModel


class DetailEventActivity : AppCompatActivity() {

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
    }
}
