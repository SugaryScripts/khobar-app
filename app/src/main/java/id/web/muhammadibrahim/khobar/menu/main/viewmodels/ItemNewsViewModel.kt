package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.databinding.ObservableField
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel

class ItemNewsViewModel(val newsModel: NewsModel){
    var title = ObservableField(newsModel.title)
    var category = ObservableField(newsModel.category)
    var date = ObservableField(newsModel.date)
    var image = ObservableField(newsModel.img_url)
}