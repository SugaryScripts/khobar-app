package id.web.muhammadibrahim.khobar.menu.university.viewmodels

import android.databinding.ObservableField

class AboutViewModel(text:String, image:String) {
    val text = ObservableField(text)
    val image = ObservableField(image)
}