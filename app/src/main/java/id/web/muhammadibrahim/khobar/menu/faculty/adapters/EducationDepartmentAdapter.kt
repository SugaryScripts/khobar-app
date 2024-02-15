package id.web.muhammadibrahim.khobar.menu.faculty.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemEducationDepartmentBinding
import id.web.muhammadibrahim.khobar.menu.faculty.models.DepartmentModel
import id.web.muhammadibrahim.khobar.menu.faculty.viewmodels.ItemDepartmentViewModel

class EducationDepartmentAdapter(private val clickListener: EducationDepartmentClickListener) : RecyclerView.Adapter<EducationDepartmentAdapter.DepartmentViewHolder>() {
    private val dataset: MutableList<DepartmentModel> = mutableListOf()

    inner class DepartmentViewHolder(private val bindings: ItemEducationDepartmentBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: DepartmentModel, clickListener: EducationDepartmentClickListener) = with(bindings) {
            val binds = ItemDepartmentViewModel(item)
            bindings.item = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickFacultyDepartmentItem(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val binding: ItemEducationDepartmentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_education_department, parent, false)
        return DepartmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], clickListener)

    override fun getItemCount() = dataset.size

    fun setItemDepartment(facultyDepartmentModel: MutableList<DepartmentModel>?) {
        dataset.clear()
        dataset.apply {
            clear()
            addAll(facultyDepartmentModel!!)
        }
        notifyDataSetChanged()
    }

    interface EducationDepartmentClickListener {
        fun onClickFacultyDepartmentItem(model: DepartmentModel)
    }
}