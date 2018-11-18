package id.web.muhammadibrahim.khobar.menu.main.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.ItemLibraryBinding
import id.web.muhammadibrahim.khobar.menu.main.models.BookModel
import id.web.muhammadibrahim.khobar.menu.main.viewmodels.ItemBookViewModel

class LibraryAdapter(private val bookClickListener: BookClickListener):
    RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>() {
    private val dataset: MutableList<BookModel> = mutableListOf()

    inner class LibraryViewHolder(private val bindings: ItemLibraryBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: BookModel, clickListener: BookClickListener) = with(bindings) {
            val binds = ItemBookViewModel(item)
            bindings.book = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickBook(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding: ItemLibraryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_library, parent, false)
        return LibraryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], bookClickListener)

    override fun getItemCount() = dataset.size

    fun setBooks(bookModel: MutableList<BookModel>?) {
        dataset.apply {
            clear()
            addAll(bookModel!!)
        }
        notifyDataSetChanged()
    }

    interface BookClickListener{
        fun onClickBook(model: BookModel)
    }
}