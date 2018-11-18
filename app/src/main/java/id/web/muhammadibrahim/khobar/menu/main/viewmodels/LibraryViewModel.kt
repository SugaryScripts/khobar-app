package id.web.muhammadibrahim.khobar.menu.main.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel

class FragmentLibraryViewModel: ViewModel() {
    var bookModel: MutableLiveData<MutableList<BookModel>> = MutableLiveData()

    init {
        addDummyLibrary()
    }

    private fun addDummyLibrary() {
        val books: MutableList<BookModel> = mutableListOf()
        books.add(BookModel("Journey Into Europe","https://journeyintoeuropedotcom.files.wordpress.com/2015/09/jie-cover-page-001.jpg","4623"))
        books.add(BookModel("Harry The Stars Are Legion Final","https://ewedit.files.wordpress.com/2017/07/the-stars-are-legion-final-cover.jpg","0293"))
        books.add(BookModel("Buku Pintar Sejarah Islam : Jejak Langkah Kaki","https://99designs-blog.imgix.net/blog/wp-content/uploads/2017/02/attachment_70356173-e1488218242409.jpg?auto=format&q=60&fit=max&w=930","2342"))
        books.add(BookModel("Canva Purple Paint Strokes Abstract Art Creativity","https://marketplace.canva.com/MACBTyJGXXY/1/0/thumbnail_large/canva-purple-paint-strokes-abstract-art-creativity-book-cover-MACBTyJGXXY.jpg","4123"))
        books.add(BookModel("Stardew Valley","01/89/65/19/500_F_189651964_ztzzUQWQCW67Dn2PqYquPdwc0kmLcbDS.jpg","2314"))
        books.add(BookModel("The Razor Marrow Maze ","https://99designs-blog.imgix.net/wp-content/uploads/2017/07/latest-1-e1500061170993.jpg?auto=format&q=60&fit=max&w=930","4324"))
        bookModel.value = books
    }
}