package id.web.muhammadibrahim.khobar.menu.faculty.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import id.web.muhammadibrahim.khobar.menu.faculty.models.DepartmentModel

class EducationDepartmentViewModel : ViewModel() {
    var departmentModel: MutableLiveData<MutableList<DepartmentModel>> = MutableLiveData()

    init {
        addDummyDepartment()
    }

    private fun addDummyDepartment() {
        val departmentModels: MutableList<DepartmentModel> = mutableListOf()
        departmentModels.add(DepartmentModel("Islamic Education", "education"))
        departmentModels.add(DepartmentModel("Arabic Language Teaching", "education"))
        departmentModel.value = departmentModels
    }
}
