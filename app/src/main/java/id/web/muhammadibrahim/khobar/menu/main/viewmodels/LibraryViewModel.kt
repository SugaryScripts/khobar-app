package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel

class LibraryViewModel: ViewModel() {
    var bookModel: MutableLiveData<MutableList<BookModel>> = MutableLiveData()

    init {
        addDummyLibrary()
    }

    private fun addDummyLibrary() {
        val books: MutableList<BookModel> = mutableListOf()
        books.add(BookModel("Journey Into Europe",
            "https://journeyintoeuropedotcom.files.wordpress.com/2015/09/jie-cover-page-001.jpg",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi III",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        books.add(BookModel("Harry The Stars Are Legion Final",
            "https://ewedit.files.wordpress.com/2017/07/the-stars-are-legion-final-cover.jpg",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi IV",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        books.add(BookModel("Buku Pintar Sejarah Islam : Jejak Langkah Kaki",
            "https://99designs-blog.imgix.net/blog/wp-content/uploads/2017/02/attachment_70356173-e1488218242409.jpg?auto=format&q=60&fit=max&w=930",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi V",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        books.add(BookModel("Canva Purple Paint Strokes Abstract Art Creativity",
            "https://marketplace.canva.com/MACBTyJGXXY/1/0/thumbnail_large/canva-purple-paint-strokes-abstract-art-creativity-book-cover-MACBTyJGXXY.jpg",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi VI",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        books.add(BookModel("Stardew Valley",
            "01/89/65/19/500_F_189651964_ztzzUQWQCW67Dn2PqYquPdwc0kmLcbDS.jpg",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi VII",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        books.add(BookModel("The Razor Marrow Maze ",
            "https://99designs-blog.imgix.net/wp-content/uploads/2017/07/latest-1-e1500061170993.jpg?auto=format&q=60&fit=max&w=930",
            "Qasim A. Ibrahim dan Muhammad A, Salhe",
            "Edisi VIII",
            "29836219836",
            "Penerbit Reneka Cipta",
            "Jakarta",
            "2016",
            "201.9",
            "4120387102938",
            "xx + 340 hlm. 15x23 cm",
            "Perpustakan UNIDA Gontor Pusat"))
        bookModel.value = books
    }
}