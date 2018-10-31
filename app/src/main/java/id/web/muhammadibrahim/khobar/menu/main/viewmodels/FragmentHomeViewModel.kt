package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel

class FragmentHomeViewModel : ViewModel() {
    var eventModel: MutableLiveData<MutableList<EventModel>> = MutableLiveData()
    var newsModel:  MutableLiveData<MutableList<NewsModel>> = MutableLiveData()
    init {
        var eventModels: MutableList<EventModel> = mutableListOf()
        for (i in 1..10)
        eventModels.add(EventModel(i, "Lorem ipsum pidum thir nagh nog pusum $i","https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg","30","OKT","08:00 - 09:00"))
        eventModel.value = eventModels

        val i = 1
        var newsModels: MutableList<NewsModel> = mutableListOf()
        newsModels.add(
            NewsModel(
                i,
                "Artikel",
                "Lorem ipsum pidum thir nagh nog pusum $i",
                "31 September 2000",
                "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
            )
        )
        newsModels.add(NewsModel(
            i,
            "Berita-Umum",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "Info-2",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "Informasi-Lembaga-dan-Biro",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "Informasi-Program-Studi",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "Informasi-Universitas",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "Journal",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "News-Ar",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModels.add(NewsModel(
            i,
            "News-En",
            "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
            "31 September 2000",
            "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
        ))
        newsModel.value = newsModels
    }
}
