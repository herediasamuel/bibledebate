package com.bibledebate.domain.usecase

import com.bibledebate.domain.model.Book
import com.bibledebate.data.repository.BibleRepository

/**
 * Created by SmarClarity on 19-01-2018.
 */
class GetBookBible(private val bookBibleRepository: BibleRepository) {
    operator fun invoke():List<Book> = bookBibleRepository.getAllBookBible()
}