package id.web.muhammadibrahim.khobar.menu.main.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemFacultyDepartmentBinding
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemFacultyDepartmentViewModel

class FacultyNDepartmentAdapter(private val clickListener: FacultyDepartmentClickListener) : RecyclerView.Adapter<FacultyNDepartmentAdapter.FacultyNDepartmentViewHolder>() {
        private val dataset: MutableList<FacultyNDepartmentModel> = mutableListOf()

        inner class FacultyNDepartmentViewHolder(private val bindings: ItemFacultyDepartmentBinding) : RecyclerView.ViewHolder(bindings.root) {
            fun bind(item: FacultyNDepartmentModel, clickListener: FacultyDepartmentClickListener) = with(bindings) {
                val binds = ItemFacultyDepartmentViewModel(item)
                bindings.item = binds
                bindings.executePendingBindings()

                bindings.root.setOnClickListener {
                    clickListener.onClickFacultyDepartmentItem(item)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyNDepartmentViewHolder {
            val binding: ItemFacultyDepartmentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_faculty_department, parent, false)
            return FacultyNDepartmentViewHolder(binding)
        }

        override fun onBindViewHolder(holder: FacultyNDepartmentViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], clickListener)

        override fun getItemCount() = dataset.size

    fun setItemFacultyDepartment(facultyDepartmentModel: MutableList<FacultyNDepartmentModel>?) {
        dataset.clear()
        dataset.apply {
            clear()
            addAll(facultyDepartmentModel!!)
        }
        notifyDataSetChanged()
    }

    interface FacultyDepartmentClickListener {
        fun onClickFacultyDepartmentItem(model: FacultyNDepartmentModel)
    }
}