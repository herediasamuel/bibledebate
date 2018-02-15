package com.bibledebate.ui.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bibledebate.R
import com.bibledebate.domain.model.Book
import com.bibledebate.ui.presenter.BookBiblePresenter
import com.bibledebate.ui.utilites.setImageBackground


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
        itemView.setOnClickListener { presenter.onBookBibleClicked(bookBible) }
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