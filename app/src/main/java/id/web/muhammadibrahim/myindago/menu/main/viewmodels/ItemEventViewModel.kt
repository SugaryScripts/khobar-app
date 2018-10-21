package id.web.muhammadibrahim.myindago.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel

class ItemEventViewModel(eventModel: EventModel){
    var title = ObservableField(eventModel.title)
    var date = ObservableField(eventModel.date)
    var image = ObservableField(eventModel.img_url)
}