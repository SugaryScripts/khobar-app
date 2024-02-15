package id.web.muhammadibrahim.khobar.menu.department.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemIslamicEduLecturerBinding
import id.web.muhammadibrahim.khobar.menu.department.models.LecturerModel
import id.web.muhammadibrahim.khobar.menu.department.viewmodels.ItemIslamicEduLecturerViewModel

class IslamicEduLecturerAdapter(private val clickListener: LecturerClickListener):
    RecyclerView.Adapter<IslamicEduLecturerAdapter.LecturerViewHolder>() {
    private val dataset: MutableList<LecturerModel> = mutableListOf()

    inner class LecturerViewHolder(private val bindings: ItemIslamicEduLecturerBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: LecturerModel, clickListener: LecturerClickListener) = with(bindings) {
            val binds = ItemIslamicEduLecturerViewModel(item)
            bindings.item = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickLecturer(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LecturerViewHolder {
        val binding: ItemIslamicEduLecturerBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_islamic_edu_lecturer, parent, false)
        return LecturerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LecturerViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], clickListener)

    override fun getItemCount() = dataset.size

    fun setLecturers(lecturerModels: MutableList<LecturerModel>?) {
        dataset.apply {
            clear()
            addAll(lecturerModels!!)
        }
        notifyDataSetChanged()
    }

    interface LecturerClickListener{
        fun onClickLecturer(lecturer: LecturerModel)
    }
}