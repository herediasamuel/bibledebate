package com.bibledebate.domain.model

/**
 * Created by SmarClarity on 18-01-2018.
 */

data class Book(
        val name: String,
        val photo: String?,
        val isNewTestament: Boolean,
        val description: String)