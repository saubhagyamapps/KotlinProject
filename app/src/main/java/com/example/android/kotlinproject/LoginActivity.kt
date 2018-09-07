package com.example.android.kotlinproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initilazation()

    }

    private fun initilazation() {
        val sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        btnLogin.setOnClickListener {
            if (!isNullOrEmpty(etEmail.text.toString())) {
                editor.putString("email", etEmail.text.toString())
                editor.apply()
                val intent = Intent(this, NavigationBar::class.java)
                intent.putExtra("testing", etEmail.text.toString())
                startActivity(intent)
            }
        }
    }

    private fun isNullOrEmpty(str: String?): Boolean {
        if (str != null && !str.isEmpty())
            return false
        else
            Toast.makeText(this@LoginActivity, "Please enter Email ", Toast.LENGTH_SHORT).show()
        return true
    }
}




