package com.bibledebate.ui.presenter

import co.metalab.asyncawait.async
import com.bibledebate.ui.LifecycleSubscriber
import com.bibledebate.common.weak
import com.bibledebate.domain.model.Book
import com.bibledebate.domain.usecase.GetBookBible


class BookBiblePresenter (
        view: View,
        private val getBookBible : GetBookBible) : LifecycleSubscriber {


    private val view: View? by weak(view)

    override fun update() {
        view?.showLoading()
        refreshBooksBible()
    }

    private fun refreshBooksBible() = async {
        val result =  getBookBible()
        view?.hideLoading()
        when {
            result.isEmpty() -> view?.showEmptyCase()
            else -> view?.showBooksBible(result)
        }
    }

    fun onBookBibleClicked(bookBible: Book) = view?.openDetail(bookBible.name)

    interface View {
        fun hideLoading()
        fun showBooksBible(bookBible: List<Book>)
        fun showLoading()
        fun showEmptyCase()
        fun openDetail(name: String)
    }


}