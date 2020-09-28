package com.caren.irma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private var retrievedBooks = mutableListOf<Book>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        getBooks()
    }

    fun getBooks() {
        val db = FirebaseFirestore.getInstance()

        db.collection("books").get().addOnSuccessListener {
            val listOfBooks = mutableListOf<Book>()
            val books = it.documents
            for (book in books) {
                listOfBooks.add(
                    Book(
                        author = book.getString("author"),
                        title = book.getString("title"),
                        rating = book.getDouble("rating"),
                        imageUrl = book.getString("image_url")
                    )
                )
            }

            Log.i("Caren", "books " + listOfBooks.size)
            retrievedBooks = listOfBooks
            recyclerView.adapter = BookAdapter(retrievedBooks)
        }
    }
}