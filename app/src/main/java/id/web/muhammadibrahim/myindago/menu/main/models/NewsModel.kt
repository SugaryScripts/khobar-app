package id.web.muhammadibrahim.myindago.menu.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel (val id:Int = 0,
                      var category: String,
                       var title:String? = null,
                       var date:String,
                       var img_url:String): Parcelable