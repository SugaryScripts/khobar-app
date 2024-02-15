package id.web.muhammadibrahim.khobar.menu.faculty.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.faculty.models.LecturerModel

class ItemEducationLecturerViewModel(lecturer: LecturerModel){
    var name = ObservableField(lecturer.name)
    var nidn = ObservableField(lecturer.nidn)
    var niy = ObservableField(lecturer.niy)
    var image = ObservableField(lecturer.image)
}