package com.hector.ocampo.mylist.views.main.list
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hector.ocampo.mylist.R
import com.hector.ocampo.mylist.model.CurrentMovies

class ListView(private val items: List<CurrentMovies>, private val applicationContext: Context): RecyclerView.Adapter<ListView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.bind(item)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val imageView: ImageView = itemView.findViewById(R.id.movieImage)
            private val titleTextView: TextView = itemView.findViewById(R.id.movieTittle)
            private val descriptionTextView: TextView = itemView.findViewById(R.id.movieSynopsis)

            fun bind(item: CurrentMovies) {
                Glide.with(applicationContext)
                    .load(item.image)
                    .into(imageView)
                titleTextView.text = item.name
                descriptionTextView.text = item.synopsis
            }
        }
}