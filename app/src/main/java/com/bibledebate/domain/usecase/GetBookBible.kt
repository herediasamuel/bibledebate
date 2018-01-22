package com.bibledebate.domain.usecase

import com.bibledebate.domain.model.Book
import com.bibledebate.data.repository.BibleRepository


class GetBookBible(private val bookBibleRepository: BibleRepository) {
    operator fun invoke():List<Book> = bookBibleRepository.getAllBookBible()
}