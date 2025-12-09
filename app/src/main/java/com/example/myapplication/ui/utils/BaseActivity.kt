package com.example.myapplication.ui.utils

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
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
    fun setupToolBar(toolbarId: Int, showBackButton: Boolean) {
        val toolBar: Toolbar = findViewById(toolbarId)
        setSupportActionBar(toolBar)
        // tắt show title
        supportActionBar?.setDisplayShowTitleEnabled(false)
// 3. Kích hoạt nút Back (Up)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
        if (showBackButton && toolbarId != 0) {
            supportActionBar?.setHomeAsUpIndicator(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_back
                )
            )
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            // Lấy View đang có focus (thường là EditText đang mở bàn phím)
            val v = currentFocus

            // 1. Kiểm tra xem View đang focus có phải là EditText hay không
            if (v is EditText) {

                // 2. Kiểm tra xem điểm chạm có nằm ngoài phạm vi của EditText đó không
                val outRect = android.graphics.Rect()
                v.getGlobalVisibleRect(outRect)

                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {

                    // 3. Nếu chạm ra ngoài: Hủy focus và ẩn bàn phím
                    v.clearFocus()

                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}