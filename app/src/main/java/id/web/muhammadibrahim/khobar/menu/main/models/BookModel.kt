package id.web.muhammadibrahim.khobar.menu.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookModel(var title: String,
                     var cover: String,
                     var writer: String,
                     var edition: String,
                     var isbn_issn: String,
                     var publisher: String,
                     var place: String,
                     var year: String,
                     var classification: String,
                     var call_number: String,
                     var collection: String,
                     var location: String): Parcelable