package com.bibledebate.ui.view

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.View
import com.bibledebate.domain.model.Book
import com.bibledebate.domain.usecase.GetBookBibleByName
import com.bibledebate.ui.LifecycleSubscriber
import com.bibledebate.ui.presenter.BookBibleDetailPresenter
import com.bibledebate.ui.utilites.setImageBackground
import com.bibledebate.R
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import kotlinx.android.synthetic.main.book_bible_detail_activity.*

class BookBibleDetailActivity :  BaseActivity(), BookBibleDetailPresenter.View {

    companion object {
        private val BOOK_BIBLE_NAME_KEY = "book_bible_name_key"

        fun open(activity: Activity, bookBibleName: String) {
            val intent = Intent(activity, BookBibleDetailActivity::class.java)
            intent.putExtra(BOOK_BIBLE_NAME_KEY , bookBibleName)
            activity.startActivity(intent)
        }
    }

    override val presenter: BookBibleDetailPresenter by injector.instance()


    override val layoutId: Int = R.layout.book_bible_detail_activity
    override val toolbarView: Toolbar
        get() = toolbar

    override fun preparePresenter(intent: Intent?) {
        val bookBibleName = intent?.extras?.getString(BOOK_BIBLE_NAME_KEY)
        title = bookBibleName
        presenter.preparePresenter(bookBibleName)
    }

    override fun close() = finish()

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showBookBible(bookBible: Book) {
        iiv_book_bible_name.text = bookBible.name
        iiv_book_bible_description.text = bookBible.description
        iv_newtesta_badge.visibility =
                if (bookBible.isNewTestament) View.VISIBLE else View.GONE
        iv_book_bible_photo.setImageBackground(bookBible.photo)
    }

    override val activityModules = Kodein.Module(allowSilentOverride = true) {
        bind<BookBibleDetailPresenter>() with provider {
            BookBibleDetailPresenter(this@BookBibleDetailActivity, instance())
        }
        bind<GetBookBibleByName>() with provider { GetBookBibleByName(instance()) }
    }
}
