package id.web.muhammadibrahim.myindago.menu.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventModel (val id:Int = 0,
                       var title:String,
                       var img_url:String,
                       var tgl:String,
                       var bulan:String,
                       var duration:String): Parcelable