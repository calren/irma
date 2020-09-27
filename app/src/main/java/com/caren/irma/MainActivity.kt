package com.caren.irma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBooks()
    }

    fun getBooks() {
        val db = FirebaseFirestore.getInstance()

        db.collection("books").get().addOnSuccessListener {
            val books = it.documents
            for (book in books) {
                Log.i("Caren", "book " + book.get("title") + " " + book.get("date_added"))
            }
        }
    }
}