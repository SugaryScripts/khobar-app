package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel

class ItemFacultyDepartmentViewModel(model: FacultyNDepartmentModel) {
    var title = ObservableField(model.title)
    var icon = ObservableField(model.icon)
}