package id.web.muhammadibrahim.khobar.menu.faculty.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.res.Resources
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.data.AppConstants
import id.web.muhammadibrahim.khobar.menu.faculty.models.LecturerModel

class EducationLecturerViewModel : ViewModel() {
    var lecturerModel: MutableLiveData<MutableList<LecturerModel>> = MutableLiveData()
    init {
        val lecturerModels: MutableList<LecturerModel> = mutableListOf()
        for (i in 1..10)
            lecturerModels.add(LecturerModel("Ahmad Muqorobin, M. A.","2114078903","150503", AppConstants.DUMMY_TEXT))
        lecturerModel.value = lecturerModels
    }
}
