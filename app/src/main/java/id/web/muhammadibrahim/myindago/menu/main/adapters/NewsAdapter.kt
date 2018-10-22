package id.web.muhammadibrahim.myindago.menu.main.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.databinding.ItemNewsHomeBinding
import id.web.muhammadibrahim.myindago.menu.main.interfaces.NewsClickListener
import id.web.muhammadibrahim.myindago.menu.main.models.NewsModel
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.ItemNewsViewModel

class NewsAdapter(private val newsClickListener: NewsClickListener):
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private val dataset: MutableList<NewsModel> = mutableListOf()

    inner class NewsViewHolder(private val bindings: ItemNewsHomeBinding) : RecyclerView.ViewHolder(bindings.root) {
        fun bind(item: NewsModel, clickListener: NewsClickListener) = with(bindings) {
            val binds = ItemNewsViewModel(item)
            bindings.newsItem = binds
            bindings.executePendingBindings()

            bindings.root.setOnClickListener {
                clickListener.onClickNews(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: ItemNewsHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news_home, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind(dataset[holder.adapterPosition], newsClickListener)

    override fun getItemCount() = dataset.size

    fun setNews(newsModel: MutableList<NewsModel>?) {
        dataset.apply {
            clear()
            addAll(newsModel!!)
        }
        notifyDataSetChanged()
    }
}