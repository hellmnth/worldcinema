package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class homescreen : AppCompatActivity() {
    lateinit var bn: BottomNavigationView



    private val fraglist2 = listOf(Fragment4(),Fragment5(), Fragment6())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        bn=findViewById(R.id.navig)
       bn.setOnItemSelectedListener{
                when(it.itemId) {
                R.id.home->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[0]).commit()
                    Toast.makeText(this, "Вы сейчас здесь", Toast.LENGTH_SHORT).show()
                }
                R.id.podborka->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[1]).commit()
//                    val intent= Intent(this, fragments_bottom::class.java)
//                    startActivity(intent)
//                    finish()
                }
                R.id.collections->{
                    supportFragmentManager.beginTransaction().replace(R.id.framefr, fraglist2[2]).commit()
//                    val intent= Intent(this, fragments_bottom::class.java)
//                    startActivity(intent)
//                    finish()
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