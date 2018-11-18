package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel

class ItemLibraryViewModel(model: BookModel) {
    var title = ObservableField(model.title)
    var cover = ObservableField(model.cover)
    var year = ObservableField(model.year)
}