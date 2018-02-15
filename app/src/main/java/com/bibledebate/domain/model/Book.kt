package com.bibledebate.domain.model



data class Book(
        val name: String,
        val photo: String?,
        val isNewTestament: Boolean,
        val description: String)