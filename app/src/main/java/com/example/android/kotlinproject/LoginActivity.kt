package com.example.android.kotlinproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

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
                if (isEmailValid(etEmail.text.toString())) {
                    editor.putString("email", etEmail.text.toString())
                    editor.apply()
                    val intent = Intent(this, NavigationBar::class.java)
                    intent.putExtra("testing", etEmail.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalidate Email", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun isNullOrEmpty(str: String?): Boolean {
        if (str != null && !str.isEmpty()) {
            return false
        } else
            Toast.makeText(this@LoginActivity, "Please enter Email ", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

}



