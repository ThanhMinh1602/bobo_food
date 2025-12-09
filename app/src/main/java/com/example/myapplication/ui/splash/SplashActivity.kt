package com.example.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"
    private val SPLASH_TIME_OUT: Long = 3000 // 3000ms = 3 giây
    private var handler: Handler? = null

    // Khai báo Runnable để có thể hủy bỏ nếu cần (rất quan trọng)
    private val splashRunnable = Runnable {
        // 1. Tạo Intent (Giống như tạo Route trong Flutter)
        val intent = Intent(this, OnboardingActivity::class.java)

        // 2. Thực hiện chuyển màn hình
        startActivity(intent)

        // 3. Kết thúc SplashActivity (Giống như Navigator.pushReplacement)
        finish()
    }

    // =========================================================
    // 🚀 VÒNG ĐỜI CHÍNH (Entire Lifetime)
    // =========================================================

    // Tương đương: initState() + build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gắn Layout XML (bạn cần đảm bảo file activity_splash.xml tồn tại)
        setContentView(R.layout.activity_splash)

        // Khởi tạo Handler
        handler = Handler(Looper.getMainLooper())

        // Bắt đầu đếm ngược 3 giây
        handler?.postDelayed(splashRunnable, SPLASH_TIME_OUT)

        Log.d(TAG, "onCreate: Activity Created and Timer Started.")
    }

    // Tương đương: Nằm giữa initState() và build()
    override fun onStart() {
        super.onStart()
        // Nơi khởi động các tài nguyên cần thiết khi Activity sắp hiện thị
        Log.d(TAG, "onStart: Activity is about to be visible.")
    }

    // Tương đương: didChangeDependencies() hoặc khi app chuyển từ background sang foreground
    override fun onResume() {
        super.onResume()
        // Activity đã ở foreground, sẵn sàng tương tác.
        Log.d(TAG, "onResume: Activity is in the foreground and interactive.")
    }

    // =========================================================
    // 🛑 VÒNG ĐỜI DỪNG (Foreground Lifetime)
    // =========================================================

    // Tương đương: didChangeAppLifecycleState(inactive)
    override fun onPause() {
        super.onPause()
        // Nơi giải phóng các tài nguyên CPU cường độ cao (đóng camera, tắt GPS)
        // QUAN TRỌNG: Hủy bỏ chức năng chờ (Runnable) nếu người dùng thoát quá nhanh
        handler?.removeCallbacks(splashRunnable)
        Log.d(TAG, "onPause: Timer stopped, Activity is paused.")
    }

    // Tương đương: didChangeAppLifecycleState(paused)
    override fun onStop() {
        super.onStop()
        // Nơi lưu trữ dữ liệu lâu dài (ví dụ: Lưu trạng thái người dùng vào database)
        Log.d(TAG, "onStop: Activity is no longer visible.")
    }

    // Tương đương: dispose()
    override fun onDestroy() {
        // Nơi giải phóng tài nguyên cuối cùng (đóng database, hủy các listener)
        handler = null // Giải phóng Handler
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity is destroyed and memory released.")
    }
}