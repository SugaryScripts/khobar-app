package id.web.muhammadibrahim.khobar.menu.main.interfaces

import id.web.muhammadibrahim.khobar.menu.main.models.EventModel

interface EventClickListener {
    fun onClickEvent (eventModel: EventModel)
}