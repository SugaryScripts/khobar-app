package id.web.muhammadibrahim.myindago.menu.main.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ItemEventHomeBinding
import id.web.muhammadibrahim.myindago.menu.main.interfaces.EventClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.ItemEventViewModel

class EventAdapter(private val eventClickListener: EventClickListener, private val more: Boolean):
        RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    private val dataset: MutableList<EventModel> = mutableListOf()

    inner class EventViewHolder(private val bindings: ItemEventHomeBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: EventModel, clickListener: EventClickListener) = with(bindings) {
            val binds = ItemEventViewModel(item)
            bindings.itemEvent = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickEvent(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding: ItemEventHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_event_home, parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], eventClickListener)

    override fun getItemCount() = dataset.size

    fun setEvents(eventModel: MutableList<EventModel>?) {
        dataset.clear()
        if (more) dataset.addAll(eventModel!!)
        else for (i in 0..4) dataset.add(eventModel!![i])
        notifyDataSetChanged()
    }
}