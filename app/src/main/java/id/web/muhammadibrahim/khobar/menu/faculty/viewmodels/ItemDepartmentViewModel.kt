package id.web.muhammadibrahim.khobar.menu.faculty.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.faculty.models.DepartmentModel

class ItemDepartmentViewModel(model: DepartmentModel) {
    var title = ObservableField(model.title)
    var icon = ObservableField(model.icon)
}