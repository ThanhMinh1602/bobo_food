package com.example.myapplication.ui.auth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.ui.utils.BaseActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : BaseActivity() {
    private val TAG = "LoginActivityDebug"
    private lateinit var emailTextField: TextInputLayout
    private lateinit var passwordTextField: TextInputLayout
    private lateinit var loginBtn: Button
    private lateinit var tvForgot: TextView
    private lateinit var tvSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupToolBar(R.id.commonToolbar, true)

        emailTextField = findViewById(R.id.emailTextField)
        passwordTextField = findViewById(R.id.passwordTextField)
        loginBtn = findViewById(R.id.login_btn)
//        tvForgot = findViewById(R.id.tv_forgot)
        tvSignup = findViewById(R.id.tv_signup)

        loginBtn.setOnClickListener {
            onTapLogin()
        }




    }


    private fun onTapLogin(){
        val email = emailTextField.editText?.text.toString()
        val password = passwordTextField.editText?.text.toString()

        // 🚀 LOGGING: Kiểm tra giá trị nhập vào
        Log.d(TAG, "Email nhập vào: '$email'")
        Log.d(TAG, "Password length: ${password.length}")

        if (email == "ThanhMinh" && password == "123456" ){
            Log.i(TAG, "Đăng nhập: THÀNH CÔNG")
            showToast("Đăng nhập thành công!")
        }else{
            Log.e(TAG, "Đăng nhập: THẤT BẠI (Sai tài khoản/mật khẩu)") // 🚀 LOGGING ERROR
            showToast("Tên đăng nhập hoặc mật khẩu không đúng.")
        }
    }

    private fun onTapForgot(){

    }

    private fun onTapSignup(){}
}