package com.bibledebate.domain.usecase

import com.bibledebate.data.repository.BibleRepository
import com.bibledebate.domain.model.Book

class GetBookBibleByName(private val bibleRepository: BibleRepository ){

    operator fun invoke(name: String) : Book = bibleRepository.getByName(name)
}
