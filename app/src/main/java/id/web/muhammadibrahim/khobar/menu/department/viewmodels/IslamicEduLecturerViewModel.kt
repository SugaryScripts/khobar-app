package id.web.muhammadibrahim.khobar.menu.department.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import id.web.muhammadibrahim.khobar.data.AppConstants
import id.web.muhammadibrahim.khobar.menu.department.models.LecturerModel

class IslamicEduLecturerViewModel : ViewModel() {
    var lecturerModel: MutableLiveData<MutableList<LecturerModel>> = MutableLiveData()
    init {
        val lecturerModels: MutableList<LecturerModel> = mutableListOf()
        for (i in 1..10)
            lecturerModels.add(LecturerModel("Ahmad Muqorobin, M. A.","2114078903","150503", AppConstants.DUMMY_TEXT))
        lecturerModel.value = lecturerModels
    }
}
