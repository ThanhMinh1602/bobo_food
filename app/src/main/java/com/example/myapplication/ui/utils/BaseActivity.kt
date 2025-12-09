package com.example.myapplication.ui.utils

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    /**
     * Hàm thiết lập Toolbar (AppBar) dùng chung.
     * Cần được gọi trong onCreate() của Activity con sau khi gọi setContentView().
     * @param toolbarId: ID của Toolbar trong Layout XML (ví dụ: R.id.commonToolbar)
     * @param title: Tiêu đề muốn hiển thị trên Toolbar
     * @param showBackButton: Hiển thị mũi tên quay lại hay không
     */
    fun setupToolBar(toolbarId: Int, showBackButton: Boolean){
        val toolBar: Toolbar = findViewById(toolbarId)
        setSupportActionBar(toolBar)
        // tắt show title
        supportActionBar?.setDisplayShowTitleEnabled(false)
// 3. Kích hoạt nút Back (Up)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
        if (showBackButton && toolbarId != 0){
            supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_back))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onOptionsItemSelected(item)
    }
    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}