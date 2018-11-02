package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.main.models.FacultyNDepartmentModel

class FacultyNDepartmentViewModel : ViewModel() {
    var facultyModel: MutableLiveData<MutableList<FacultyNDepartmentModel>> = MutableLiveData()
    var departmentModel: MutableLiveData<MutableList<FacultyNDepartmentModel>> = MutableLiveData()

    init {
        addDummyFaculty()
        addDummyDepartment()
    }

    private fun addDummyFaculty() {
        val facultyModels: MutableList<FacultyNDepartmentModel> = mutableListOf()
        facultyModels.add(FacultyNDepartmentModel("Education", "education"))
        facultyModels.add(FacultyNDepartmentModel("Ushuluddin", "ushuluddin"))
        facultyModels.add(FacultyNDepartmentModel("Shari'ah", "shariah"))
        facultyModels.add(FacultyNDepartmentModel("Science & Technology", "science"))
        facultyModels.add(FacultyNDepartmentModel("Humanities", "humanities"))
        facultyModels.add(FacultyNDepartmentModel("Health", "health"))
        facultyModels.add(FacultyNDepartmentModel("Economics & Management", "economic"))
        facultyModel.value = facultyModels
    }

    private fun addDummyDepartment() {
        val departmentModels: MutableList<FacultyNDepartmentModel> = mutableListOf()
        departmentModels.add(FacultyNDepartmentModel("Islamic Education", "education"))
        departmentModels.add(FacultyNDepartmentModel("Arabic Language Teaching", "education"))
        departmentModels.add(FacultyNDepartmentModel("Comparative Study of Religion", "ushuluddin"))
        departmentModels.add(FacultyNDepartmentModel("Aqidah and Islamic Thought", "ushuluddin"))
        departmentModels.add(FacultyNDepartmentModel("Al-Qur’an and Tafsir", "ushuluddin"))
        departmentModels.add(FacultyNDepartmentModel("Comparative School of Law", "shariah"))
        departmentModels.add(FacultyNDepartmentModel("Islamic Economic Laws", "shariah"))
        departmentModels.add(FacultyNDepartmentModel("Information Technology", "science"))
        departmentModels.add(FacultyNDepartmentModel("Agro-industrial Technology", "science"))
        departmentModels.add(FacultyNDepartmentModel("Agro-technology", "science"))
        departmentModels.add(FacultyNDepartmentModel("International Relations", "humanities"))
        departmentModels.add(FacultyNDepartmentModel("Communication Sciences", "humanities"))
        departmentModels.add(FacultyNDepartmentModel("Pharmacy", "health"))
        departmentModels.add(FacultyNDepartmentModel("Nutrition", "health"))
        departmentModels.add(FacultyNDepartmentModel("Occupational Safety and Health", "health"))
        departmentModels.add(FacultyNDepartmentModel("Islamic Economics", "economic"))
        departmentModels.add(FacultyNDepartmentModel("Management", "economic"))
        departmentModel.value = departmentModels
    }
}
