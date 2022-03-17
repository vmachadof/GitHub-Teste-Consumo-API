package com.example.testestant.Model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testestant.R.id
import com.example.testestant.utils.Utils.loadUrl

class ItensViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    private val imageView_backdrop_path = itemView.findViewById<ImageView>(id.imageView_backdrop_path)
    private val textView_title = itemView.findViewById<TextView>(id.textView_title)
    private val textView_genre = itemView.findViewById<TextView>(id.textView_genre)
    private val textView_year = itemView.findViewById<TextView>(id.textView_year)

    fun bind(item: Itens ) {
        textView_genre.text = item.genre
        textView_title.text = item.title
        textView_year.text = item.year
        imageView_backdrop_path.loadUrl(
            view,
            item.backdrop_path)
        }
    }

