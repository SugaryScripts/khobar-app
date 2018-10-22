package id.web.muhammadibrahim.myindago.menu.main.viewmodels

import android.databinding.ObservableField
import android.graphics.drawable.Drawable
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ItemNewsHomeBinding
import id.web.muhammadibrahim.myindago.menu.main.models.NewsModel

class ItemNewsViewModel(val newsModel: NewsModel){
    var title = ObservableField(newsModel.title)
    var category = ObservableField(newsModel.category)
    var date = ObservableField(newsModel.date)
    var image = ObservableField(newsModel.img_url)
}