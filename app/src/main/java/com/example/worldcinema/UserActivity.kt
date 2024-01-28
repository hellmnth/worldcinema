package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class UserActivity : AppCompatActivity() {
    lateinit var tb1: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val love_res: RecyclerView =findViewById((R.id.love_view))
        love_res.adapter=love_adapter(this,PosterList().list)

        tb1=findViewById(R.id.toolbar1)
        setSupportActionBar(this.tb1)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Обратно"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                val intent= Intent(this, fragments_bottom::class.java)
                startActivity(intent)
                finish()
            }
            R.id.one -> {
                val getint=Intent(this, get_activity::class.java)
                startActivity(getint)
                finish()
            }
            R.id.two -> {
                val inte= Intent(this, MainActivity2::class.java)
                startActivity(inte)
                finish()
            }
            R.id.three -> {
                val int= Intent(this, UserActivity::class.java)
                startActivity(int)
                finish()
            }
        }
        return true
    }
}