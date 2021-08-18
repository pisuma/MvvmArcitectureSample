package com.example.mvvmarcitecturesample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarcitecturesample.R
import com.example.mvvmarcitecturesample.databinding.ActivityMainBinding
import com.example.mvvmarcitecturesample.viewmodel.BookDetailViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //データバインディングのLifecycleOwnerにActivityがもつLifecycleOwnerをセットしています。
        //これを怠るとViewにバインドされているLiveDataが監視されず、LiveDataの値が更新されてもViewに反映されません。
        binding.lifecycleOwner = this

        //ViewModelインスタンスを生成して取得する
        val bookDetailViewModel = ViewModelProvider(this).get(BookDetailViewModel::class.java)
        binding.viewModel = bookDetailViewModel

        if (savedInstanceState == null) {
            //本の詳細の取得をリクエストする。
            bookDetailViewModel.fetchBookDetail()
        }

        //本のタイトルと本の金額を購読してViewに反映する
        bookDetailViewModel.title.observe(this, { title ->
            findViewById<TextView>(R.id.book_title).text =
                getString(R.string.book_title)
        })
        bookDetailViewModel.amount.observe(this, { amount ->
            findViewById<TextView>(R.id.book_amount).text =
                getString(R.string.book_amount)
        })
    }
}