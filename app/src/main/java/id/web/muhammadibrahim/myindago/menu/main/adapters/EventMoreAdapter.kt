package id.web.muhammadibrahim.myindago.menu.main.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ItemEventMoreBinding
import id.web.muhammadibrahim.myindago.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.ItemEventViewModel

class EventMoreAdapter(private val eventClickListener: EventClickListener):
    RecyclerView.Adapter<EventMoreAdapter.EventMoreViewHolder>() {
    private val dataset: MutableList<EventModel> = mutableListOf()

    inner class EventMoreViewHolder(private val bindings: ItemEventMoreBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: EventModel, clickListener: EventClickListener) = with(bindings) {
            val binds = ItemEventViewModel(item)
            bindings.viewmodel = binds
            bindings.executePendingBindings()

            bindings.btnShowEventMoreITEM.setOnClickListener {
                clickListener.onClickEvent(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventMoreViewHolder {
        val binding: ItemEventMoreBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_event_more, parent, false)
        return EventMoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventMoreViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], eventClickListener)

    override fun getItemCount() = dataset.size

    fun setEvents(eventModel: MutableList<EventModel>?) {
        dataset.apply {
            clear()
            addAll(eventModel!!)
        }
        notifyDataSetChanged()
    }
}