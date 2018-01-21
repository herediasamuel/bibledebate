package com.bibledebate.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.smarclarity.bible_ebate.R
import com.bibledebate.model.Book
import com.bibledebate.presenter.BookBiblePresenter
import com.bibledebate.utilites.setImageBackground

/**
 * Created by SmarClarity on 19-01-2018.
 */
class BookViewHolder (itemView: View,
                      private val presenter: BookBiblePresenter) : RecyclerView.ViewHolder(itemView) {

    private val photoImageView: ImageView = itemView.findViewById(R.id.super_book_photo)
    private val nameTextView: TextView = itemView.findViewById(R.id.super_book_name)
    private val bookBadgeView: View = itemView.findViewById(R.id.book_testament)

    fun render(bookBible: Book) {
        hookListeners(bookBible)
        renderBookPhoto(bookBible.photo)
        renderBookName(bookBible.name)
        renderNewTestament(bookBible.isNewTestament)
    }

    private fun hookListeners(bookBible: Book) {
        //itemView.setOnClickListener { presenter.onSuperHeroClicked(bookBible) }
    }

    private fun renderBookPhoto(photo: String?) {
        photoImageView.setImageBackground(photo)
    }

    private fun renderBookName(name: String) {
        nameTextView.text = name
    }

    private fun renderNewTestament(isNewTestament: Boolean) {
        bookBadgeView.visibility = if (isNewTestament) View.VISIBLE else View.GONE
    }
}