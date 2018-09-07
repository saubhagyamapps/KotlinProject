package com.example.android.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(), View.OnClickListener {
    var a: String = ""
    var b: String = ""
    private val TAG = this::class.java.simpleName

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnClick -> {
                val intent = Intent(this, NavigationBar::class.java)
                intent.putExtra("testing", "ok")
                startActivity(intent)
            }
            R.id.txtName -> {
                Toast.makeText(this@MainActivity, txtName.text.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, txtName.text.toString(), Toast.LENGTH_LONG).show()
        txtName.setOnClickListener(this)
        btnClick.setOnClickListener(this)

    }


}




