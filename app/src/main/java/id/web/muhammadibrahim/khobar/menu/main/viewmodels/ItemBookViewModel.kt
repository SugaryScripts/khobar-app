package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel

class ItemBookViewModel(model: BookModel) {
    var title = ObservableField(model.title)
    var cover = ObservableField(model.cover)
    var writer = ObservableField(model.writer)
    var edition = ObservableField(model.edition)
    var isbn_issn = ObservableField(model.isbn_issn)
    var publisher = ObservableField(model.publisher)
    var place = ObservableField(model.place)
    var year = ObservableField(model.year)
    var classification = ObservableField(model.classification)
    var call_number = ObservableField(model.call_number)
    var collection = ObservableField(model.collection)
    var location = ObservableField(model.location)
}