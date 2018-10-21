package id.web.muhammadibrahim.myindago.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.myindago.menu.main.models.EventModel

class FragmentHomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var eventModel: MutableLiveData<MutableList<EventModel>> = MutableLiveData()
    init {
        var eventModels: MutableList<EventModel> = mutableListOf()
        for (i in 1..10)
        eventModels.add(EventModel(0, "Lorem ipsum pidum thir nagh nog pusum $i","30 September 2000","https://images.wallpaperscraft.com/image/neko_yanshoujie_room_girl_graphic_hand_headphones_easel_shape_books_food_camera_lamp_chair_decor_94921_1920x1080.jpg"))
        eventModel.value = eventModels
    }
}
