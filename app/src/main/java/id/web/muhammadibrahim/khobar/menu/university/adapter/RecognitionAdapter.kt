package id.web.muhammadibrahim.khobar.menu.university.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemRecognitionUniversityBinding
import id.web.muhammadibrahim.khobar.menu.university.models.RecognitionModel
import id.web.muhammadibrahim.khobar.menu.university.viewmodels.ItemRecognitionViewModel

class RecognitionAdapter(private val clickListener: RecognitionClickListener):
        RecyclerView.Adapter<RecognitionAdapter.NoteViewHolder>() {
    private val dataset: MutableList<RecognitionModel> = mutableListOf()

    inner class NoteViewHolder(private val bindings: ItemRecognitionUniversityBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: RecognitionModel, clickListener: RecognitionClickListener) = with(bindings) {
            val binds = ItemRecognitionViewModel(item)
            bindings.item = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickRecognition(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding: ItemRecognitionUniversityBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_recognition_university, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], clickListener)

    override fun getItemCount() = dataset.size

    fun setData(recognitionModels: MutableList<RecognitionModel>?) {
        dataset.apply {
            clear()
            addAll(recognitionModels!!)
        }
        notifyDataSetChanged()
    }

    interface RecognitionClickListener {
        fun onClickRecognition (recognitionModel: RecognitionModel)
    }
}