package id.web.muhammadibrahim.myindago.menu.main.interfaces

import id.web.muhammadibrahim.myindago.menu.main.models.EventModel

interface EventClickListener {
    fun onClickEvent (eventModel: EventModel)
}