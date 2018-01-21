package com.bibledebate.data.repository

import com.bibledebate.domain.model.Book

/**
 * Created by SmarClarity on 19-01-2018.
 */
class BibleRepository {

    private val bookBible: List<Book>

    init {
        bookBible = insertData()
    }

    fun getAllBookBible() : List<Book> {
        return bookBible
    }

    fun getByName(name: String) : Book {
        return bookBible.first { it.name == name }
    }

    private fun insertData() : List<Book> {
        return listOf(Book(name = "Genesis",
                photo = "https://i.pinimg.com/564x/ed/b1/3b/edb13b2c31190ecfeb41d9c77b5554c1--biblical-art-biblical-quotes.jpg",
                isNewTestament = false,
                description = "Primer Libro de la Biblia"),
                Book(name = "Exodo",
                        photo = "https://assetsnffrgf-a.akamaihd.net/assets/m/502013369/univ/art/502013369_univ_lsr_lg.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia"),
                Book(name = "Levitico",
                        photo = "https://s-media-cache-ak0.pinimg.com/originals/96/5f/9a/965f9a8b220009d14526b4820be857b0.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia"),
                Book(name = "Numeros",
                        photo = "https://assetsnffrgf-a.akamaihd.net/assets/m/502016105/univ/art/502016105_univ_lsr_lg.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia"),
                Book(name = "Deuteronomio",
                        photo = "https://s-media-cache-ak0.pinimg.com/originals/d6/b7/de/d6b7dea256509cae49560fabf67cc543.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia"),
                Book(name = "Josue",
                        photo = "https://assetsnffrgf-a.akamaihd.net/assets/m/502015220/univ/art/502015220_univ_lsr_lg.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia"),
                Book(name = "Jueces",
                        photo = "https://assetsnffrgf-a.akamaihd.net/assets/m/1102016040/univ/art/1102016040_univ_lsr_xl.jpg",
                        isNewTestament = false,
                        description = "Primer Libro de la Biblia")
                )
    }
}