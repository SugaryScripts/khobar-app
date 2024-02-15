package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel

class ItemEventViewModel(eventModel: EventModel){
    var title = ObservableField(eventModel.title)
    var image = ObservableField(eventModel.img_url)
    var tgl = ObservableField(eventModel.tgl)
    var bulan = ObservableField(eventModel.bulan)
    var duration = ObservableField(eventModel.duration)
}