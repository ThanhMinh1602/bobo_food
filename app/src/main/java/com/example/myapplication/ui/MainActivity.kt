package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem // Cần thiết cho onOptionsItemSelected
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Gắn Toolbar

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // 2. Thiết lập Title và Nút Back
        supportActionBar?.title = "Hồ sơ cá nhân"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // 3. Xử lý sự kiện khi bấm vào nút Quay lại (Up Button) trên Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Kiểm tra xem ID của item được bấm có phải là nút Home/Up không
        if (item.itemId == android.R.id.home) {
            // Đóng Activity hiện tại
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}