package com.example.worldcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.worldcinema.databinding.ActivityDrawerLayoutBinding
import com.example.worldcinema.databinding.ActivityMainBinding
import kotlin.time.measureTime

class drawer_layout : AppCompatActivity() {
    private lateinit var conf:AppBarConfiguration
    private lateinit var navContr:NavController
    private lateinit var binding:ActivityDrawerLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_drawer_layout)
        binding=ActivityDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.itb.toolbar2)
        navContr=findNavController(R.id.fragmentContainerView4)
        conf=AppBarConfiguration(
            setOf(
                R.id.item1,
                R.id.item2,
                R.id.item3), binding.drawer
            )
        setupActionBarWithNavController(navContr, conf)
        binding.navview.setupWithNavController(navContr)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navContr.navigateUp(conf)||super.onSupportNavigateUp()
    }
}