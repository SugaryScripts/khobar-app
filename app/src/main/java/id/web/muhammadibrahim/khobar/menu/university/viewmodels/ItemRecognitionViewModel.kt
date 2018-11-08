package id.web.muhammadibrahim.khobar.menu.university.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.university.models.RecognitionModel


class ItemRecognitionViewModel(recognition: RecognitionModel){
    var text = ObservableField(recognition.text)
    var year = ObservableField(recognition.year)
}