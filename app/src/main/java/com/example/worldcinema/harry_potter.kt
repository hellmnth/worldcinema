package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class harry_potter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.harry_potter_activity)
    }

    fun books(view: View) {
        val intent= Intent(this, harry_books::class.java)
        startActivity(intent)
        finish()
    }
    fun character(view: View) {
        val int=Intent(this, harry_character::class.java)
        startActivity(int)
        finish()
    }
}