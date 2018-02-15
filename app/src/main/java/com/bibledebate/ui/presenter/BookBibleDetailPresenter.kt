package com.bibledebate.ui.presenter

import co.metalab.asyncawait.async
import com.bibledebate.domain.usecase.GetBookBibleByName
import com.bibledebate.ui.LifecycleSubscriber
import com.bibledebate.common.weak
import com.bibledebate.domain.model.Book


class BookBibleDetailPresenter(
        view: View,
        private val getBookBibleByName: GetBookBibleByName) :
        LifecycleSubscriber {

    private val view: View? by weak(view)
    private lateinit var name: String

    fun preparePresenter(name: String?) {
        if (name != null) {
            this.name = name
        } else {
            view?.close()
        }
    }

    override fun update() {
        view?.showLoading()
        refreshBookBible()
    }

    private fun refreshBookBible() = async {
        val result = await { getBookBibleByName(name) }
        view?.hideLoading()
        view?.showBookBible(result)
    }


    interface View {
        fun close()
        fun showLoading()
        fun hideLoading()
        fun showBookBible(bookBible : Book)
    }
}