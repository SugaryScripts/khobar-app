package id.web.muhammadibrahim.khobar.menu.university.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.university.models.RecognitionModel

class RecognitionViewModel: ViewModel() {
    var recognitionModel: MutableLiveData<MutableList<RecognitionModel>> = MutableLiveData()

    init {
        val recognitionModels: MutableList<RecognitionModel> = mutableListOf()
        recognitionModels.add(RecognitionModel("Gadjah Mada University, Yogyakarta, Indonesia","1973"))
        recognitionModels.add(RecognitionModel("State University, Malang , Indonesia","1975"))
        recognitionModels.add(RecognitionModel("Faculty of Darul Ulum, Cairo University, Egypt","1981"))
        recognitionModels.add(RecognitionModel("International Islamic University, Islamabad, Pakistan","1989"))
        recognitionModels.add(RecognitionModel("International Islamic University, Kuala Lumpur, Malaysia","1994"))
        recognitionModels.add(RecognitionModel("National University, Malaysia","1998"))
        recognitionModels.add(RecognitionModel("Manila University, Philippine","1999"))
        recognitionModels.add(RecognitionModel("ISTAC, Kuala Lumpur, Malaysia","1999"))
        recognitionModels.add(RecognitionModel("Putra University, Malaysia","2001"))
        recognitionModels.add(RecognitionModel("University of Malaya, Kuala Lumpur, Malaysia","2005"))
        recognitionModel.value = recognitionModels
    }
}