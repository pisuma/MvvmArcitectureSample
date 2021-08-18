package com.example.mvvmarcitecturesample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarcitecturesample.Repository.BookDataRepository
import java.text.NumberFormat

class BookDetailViewModel: ViewModel() {
    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title
    private val _amount = MutableLiveData<String>()
    val amount: LiveData<String> = _amount

    fun fetchBookDetail() {
        //本の詳細を取得する
        val bookDetailModel = BookDataRepository.getBookDetail(bookId = 1)
        _title.postValue(bookDetailModel.title)
        //金額を取得し、表示用に数値をカンマ区切りにしてデータを流す
        _amount.postValue(NumberFormat.getNumberInstance().format(bookDetailModel.amount))
    }


}