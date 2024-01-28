package com.example.worldcinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var prefff:SharedPreferences
    lateinit var name:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        name=findViewById(R.id.textView1)
        prefff=getSharedPreferences("Table", MODE_PRIVATE)
        name.text=prefff?.getString("name", "")
    }

    fun home(view: View) {
        val intent=Intent(this@MainActivity4, ToolBarActivity::class.java)
        startActivity(intent)
        finish()
    }
}