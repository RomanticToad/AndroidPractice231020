package com.example.myapp_test_7_8_9_10_11_12.ch18_Test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp_test_7_8_9_10_11_12.databinding.ActivityNewsApiTestBinding

class NewsApiTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsApiTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsApiTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 레스트 서버에서(뉴스 API) 데이터 받아오고,

        // 리사이클러뷰 붙이기


    }
}