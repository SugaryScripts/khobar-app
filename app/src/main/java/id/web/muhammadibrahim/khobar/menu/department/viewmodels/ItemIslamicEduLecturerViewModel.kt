package id.web.muhammadibrahim.khobar.menu.department.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.department.models.LecturerModel

class ItemIslamicEduLecturerViewModel(lecturer: LecturerModel){
    var name = ObservableField(lecturer.name)
    var nidn = ObservableField(lecturer.nidn)
    var niy = ObservableField(lecturer.niy)
    var image = ObservableField(lecturer.image)
}