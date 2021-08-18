package com.example.mvvmarcitecturesample.Repository

import com.example.mvvmarcitecturesample.model.BookDetailModel

interface BookDataRepository {
    /* Roomなどを使ってデータベースに保存する */
    fun save(book: BookDetailModel)
    /* API Clientから本の詳細を取得してsaveでデータベースに保存します */
    fun refreshBookDetails(bookId: Int)
    /* Roomなどを使ってデータベースから本の詳細を取得する */
    fun getBookDetail(bookId: Int): BookDetailModel
}
