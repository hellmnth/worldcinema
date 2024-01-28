package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class fragments_bottom : AppCompatActivity() {
    lateinit var bn:BottomNavigationView
    private val fraglist2 = listOf(Fragment4(), Fragment5(), Fragment6())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_bottom)
        bn=findViewById(R.id.navig)
        bn.selectedItemId=R.id.home
        supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[0]).commit()
        bn.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.home->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[0]).commit()
                    Toast.makeText(this, "Сейчас вы здесь", Toast.LENGTH_LONG).show()
                }
                R.id.podborka->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[1]).commit()
//                    Toast.makeText(this, "Вы сейчас здесь", Toast.LENGTH_SHORT).show()
                }

                R.id.collections->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[2]).commit()
                }
                R.id.profile->{
                    val intent= Intent(this, UserActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
    }
}