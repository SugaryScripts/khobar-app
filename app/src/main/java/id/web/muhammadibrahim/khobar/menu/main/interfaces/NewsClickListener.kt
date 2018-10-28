package id.web.muhammadibrahim.khobar.menu.main.interfaces

import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel

interface NewsClickListener {
    fun onClickNews (newsModel: NewsModel)
}