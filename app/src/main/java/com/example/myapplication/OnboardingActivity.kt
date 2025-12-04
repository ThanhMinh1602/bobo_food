package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPage: ViewPager2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

//        1. Tìm page view bằng ID
        viewPage = findViewById(R.id.onBoardPageView)


//        2.Khởi taọ adapter
        var adapter = OnboardingAdapter(this)
        viewPage.adapter = adapter

        // 4. (Tùy chọn) Xử lý nút bấm
        val nextButton: Button = findViewById(R.id.next_btn)

        nextButton.setOnClickListener {
            // Chuyển sang trang tiếp theo khi bấm Next
            viewPage.currentItem += 1
        }
    }
}