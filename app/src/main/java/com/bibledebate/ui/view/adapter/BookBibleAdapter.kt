package com.bibledebate.ui.view.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bibledebate.R
import com.bibledebate.domain.model.Book
import com.bibledebate.ui.presenter.BookBiblePresenter



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
