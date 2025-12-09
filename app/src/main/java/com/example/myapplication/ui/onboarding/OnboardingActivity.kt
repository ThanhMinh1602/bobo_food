package com.example.myapplication.ui.onboarding

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPage: ViewPager2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

//        1. Tìm page view bằng ID
        viewPage = findViewById(R.id.onBoardPageView)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayoutIndicator)
//        2.Khởi taọ adapter
        var adapter = OnboardingAdapter(this)
        viewPage.adapter = adapter
// 🚀 3. KẾT NỐI: Sử dụng TabLayoutMediator để đồng bộ hóa
        TabLayoutMediator(tabLayout,viewPage){tab, position ->
            print(tab);
            print(position)
            tab.setCustomView(R.layout.item_tab_dot)
        }.attach()

        // 4. (Tùy chọn) Xử lý nút bấm
        val nextButton: Button = findViewById(R.id.next_btn)

        nextButton.setOnClickListener {
            // Chuyển sang trang tiếp theo khi bấm Next
            viewPage.currentItem += 1
        }
    }
}