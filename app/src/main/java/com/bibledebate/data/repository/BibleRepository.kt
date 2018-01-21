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
                photo = "https://www.google.cl/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiS38DykeTYAhUGkpAKHYZBCGIQjRwIBw&url=https%3A%2F%2Fes.slideshare.net%2Fangelusrj%2Fgenesis-julio-2013&psig=AOvVaw2gaScrn6gD5s9H4IKkOlwi&ust=1516455163503275",
                isNewTestament = true,
                description = "Primer Libro de la Biblia"),
                Book(name = "Iron Fist",
                        photo = "https://i.annihil.us/u/prod/marvel/i/mg/6/60/537bb1756cd26.jpg",
                        isNewTestament = true,
                        description = "Through concentration, Iron Fist can harness his spiritual energy, or chi, " +
                                "to augment his physical and mental capabilities to peak human levels. By focusing his chi "
                                + "into his hand, he can tap the superhuman energy of Shou-Lao and temporarily "
                                + "render his fist superhumanly powerful, immune to pain and injury; however, this "
                                + "process is mentally draining, and he usually needs recovery time before he can "
                                + "repeat it. Iron Fist can heal himself of any injury or illness and project this "
                                + "power to heal others."))
    }
}