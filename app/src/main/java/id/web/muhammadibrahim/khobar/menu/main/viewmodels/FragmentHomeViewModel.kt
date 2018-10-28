package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.main.models.EventModel
import id.web.muhammadibrahim.khobar.menu.main.models.NewsModel

class FragmentHomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var eventModel: MutableLiveData<MutableList<EventModel>> = MutableLiveData()
    var newsModel:  MutableLiveData<MutableList<NewsModel>> = MutableLiveData()
    init {
        var eventModels: MutableList<EventModel> = mutableListOf()
        for (i in 1..10)
        eventModels.add(EventModel(i, "Lorem ipsum pidum thir nagh nog pusum $i","https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg","30","OKT","08:00 - 09:00"))
        eventModel.value = eventModels

        var newsModels: MutableList<NewsModel> = mutableListOf()
        for (i in 1..10) {
            newsModels.add(
                NewsModel(
                    i,
                    "Politic",
                    "Lorem ipsum pidum thir nagh nog pusum $i",
                    "31 September 2000",
                    "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
                )
            )
            newsModels.add(NewsModel(
                i,
                "Education",
                "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
                "31 September 2000",
                "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
            ))
            newsModels.add(NewsModel(
                i,
                "Economic",
                "The education of Morrowind are pretty bad and has been writed at book of world record the worst education at all time$i",
                "31 September 2000",
                "https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"
            ))
        }
        newsModel.value = newsModels
    }
}
