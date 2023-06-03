package com.hector.ocampo.mylist.views.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hector.ocampo.mylist.R
import com.hector.ocampo.mylist.model.HistoryMovieSearched

class ItemSearch(
    private val items: List<HistoryMovieSearched>
) : RecyclerView.Adapter<ItemSearch.ViewHolder>() {
    private var onClickListener: OnClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, item )
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val historyText: TextView = itemView.findViewById(R.id.searchText)

        fun bind(item: HistoryMovieSearched) {
            historyText.text = item.text
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, text: HistoryMovieSearched)
    }
}