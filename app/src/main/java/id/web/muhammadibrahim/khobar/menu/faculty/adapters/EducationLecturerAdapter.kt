package id.web.muhammadibrahim.khobar.menu.faculty.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemEducationLecturerBinding
import id.web.muhammadibrahim.khobar.menu.faculty.models.LecturerModel
import id.web.muhammadibrahim.khobar.menu.faculty.viewmodels.ItemEducationLecturerViewModel

class EducationLecturerAdapter(private val clickListener: LecturerClickListener):
        RecyclerView.Adapter<EducationLecturerAdapter.EducationLecturerViewHolder>() {
    private val dataset: MutableList<LecturerModel> = mutableListOf()

    inner class EducationLecturerViewHolder(private val bindings: ItemEducationLecturerBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: LecturerModel, clickListener: LecturerClickListener) = with(bindings) {
            val binds = ItemEducationLecturerViewModel(item)
            bindings.item = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickLecturer(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationLecturerViewHolder {
        val binding: ItemEducationLecturerBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_education_lecturer, parent, false)
        return EducationLecturerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EducationLecturerViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], clickListener)

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