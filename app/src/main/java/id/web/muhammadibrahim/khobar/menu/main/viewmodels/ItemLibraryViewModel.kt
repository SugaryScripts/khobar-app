package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.LibraryModel

class ItemLibraryViewModel(model: LibraryModel) {
    var title = ObservableField(model.title)
    var cover = ObservableField(model.cover)
    var year = ObservableField(model.year)
}