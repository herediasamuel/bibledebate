package com.bibledebate.view.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.smarclarity.bible_ebate.R
import com.bibledebate.model.Book
import com.bibledebate.presenter.BookBiblePresenter

/**
 * Created by SmarClarity on 19-01-2018.
 */

internal class BookBibleAdapter (
         private val presenter: BookBiblePresenter): RecyclerView.Adapter<BookViewHolder>(){

     private val bookBible : MutableList<Book> = ArrayList()

     fun addAll(collection: Collection<Book>){
         bookBible.addAll(collection)
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_bible, parent,
                false)
        return BookViewHolder(view, presenter)
    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookBible[position]
        holder.render(book)
    }
    override fun getItemCount(): Int {
        return bookBible.size
    }
    fun clear() {
        bookBible.clear()
    }
}
