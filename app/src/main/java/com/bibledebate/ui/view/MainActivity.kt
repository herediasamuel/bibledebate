package com.bibledebate.ui.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.smarclarity.bible_ebate.R
import com.bibledebate.domain.model.Book
import com.bibledebate.ui.presenter.BookBiblePresenter
import com.bibledebate.domain.usecase.GetBookBible
import com.bibledebate.ui.view.adapter.BookBibleAdapter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BookBiblePresenter.View {

    override val presenter: BookBiblePresenter by injector.instance()
    private lateinit var adapter: BookBibleAdapter
    override val layoutId: Int = R.layout.activity_main
    override val toolbarView: Toolbar
        get() = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeAdapter()
        initializeRecyclerView()
    }

    private fun initializeAdapter() {
        adapter = BookBibleAdapter(presenter)
    }


    private fun initializeRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = adapter
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showEmptyCase() {
        tv_empty_case.visibility = View.VISIBLE
    }
  /*  override fun openDetail(name: String) {
        .open(activity = this, superHeroName = name)
    }*/
    override fun showBooksBible(bookBible: List<Book>) {
        adapter.clear()
        adapter.addAll(bookBible)
        adapter.notifyDataSetChanged()
    }



    override val activityModules = Kodein.Module(allowSilentOverride = true) {
        bind<BookBiblePresenter>() with provider {
            BookBiblePresenter(this@MainActivity,
                    instance())
        }
        bind<GetBookBible>() with provider { GetBookBible(instance()) }
    }
}
