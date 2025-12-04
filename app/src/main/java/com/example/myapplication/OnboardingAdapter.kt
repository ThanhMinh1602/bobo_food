package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// 🛑 Adapter này phải nhận FragmentActivity (là 'this')
class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val NUM_PAGES = 3

    // 1. Số lượng trang
    override fun getItemCount(): Int = NUM_PAGES

    // 2. Tạo Fragment dựa trên vị trí (position)
    override fun createFragment(position: Int): Fragment {

        // Dùng câu lệnh WHEN để quyết định nội dung cho từng trang
        return when (position) {
            0 -> OnboardingPageFragment.newInstance(
                title = "Welcome to the most tastiest app",
                description = "Vuốt để xem các tính năng chính của ứng dụng.",
                pageImage = R.drawable.onboard_2
            )
            1 -> OnboardingPageFragment.newInstance(
                title = "We use nitro on bicycles for delivery!",
                description = "Xem trạng thái đơn hàng của bạn theo thời gian thực.",
                pageImage = R.drawable.onboard_3 // Sử dụng một icon khác
            )
            2 -> OnboardingPageFragment.newInstance(
                title = "We’re the besties of birthday peoples",
                description = "Bấm nút Tiếp tục để khám phá ứng dụng.",
                pageImage = R.drawable.onboard_4
            )
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }
}