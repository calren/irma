package com.caren.irma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookAdapter(val books: MutableList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val ratingTextView: TextView = itemView.findViewById(R.id.rating)
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(book: Book) {
            titleTextView.text = book.title
            ratingTextView.text = "4.5 / 5"
            Glide.with(itemView.context).load(book.imageUrl).into(image);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item, parent, false)

        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}