package com.example.myapplication.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.ui.auth.LoginActivity
import com.example.myapplication.ui.utils.BaseActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : BaseActivity() {

    private lateinit var viewPage: ViewPager2
    private lateinit var skipButton: Button
    private lateinit var nextButton: Button
    private lateinit var tabLayout: TabLayout

    private val NUM_PAGES = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

//        1. Tìm page view bằng ID
        viewPage = findViewById(R.id.onBoardPageView)
        nextButton = findViewById(R.id.next_btn)
        skipButton = findViewById(R.id.skip_btn)
        tabLayout = findViewById(R.id.tabLayoutIndicator)

//        2.Khởi taọ adapter
        val adapter = OnboardingAdapter(this)
        viewPage.adapter = adapter
// 🚀 3. KẾT NỐI: Sử dụng TabLayoutMediator để đồng bộ hóa
        TabLayoutMediator(tabLayout, viewPage) { tab, position ->
            print(tab);
            print(position)

        }.attach()
        setupNextButton()
        skipButton.setOnClickListener{
            onTapToLogin()
        }
    }

    private fun setupNextButton(){
            nextButton.setOnClickListener{
                if(viewPage.currentItem == NUM_PAGES -1){
                    onTapToLogin()
                }else{
                    viewPage.currentItem += 1
                }
            }

    }
    private fun onTapToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }

}