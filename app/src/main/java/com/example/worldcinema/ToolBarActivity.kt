package com.example.worldcinema

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class ToolBarActivity : AppCompatActivity() {
    lateinit var tb:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
//
//        val video:VideoView=findViewById(R.id.videoView)
//        val mediaController=MediaController(this)
//        mediaController.setAnchorView(video)
//        val onLineurl= Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//        video.setMediaController(mediaController)
//        video.setVideoURI(onLineurl)
//        video.requestFocus()
//        video.start()

        val video2:VideoView=findViewById(R.id.videoView1)
        val mediaController1=MediaController(this)
        mediaController1.setAnchorView(video2)
        val offl=Uri.parse("android.resource://$packageName/${R.raw.klaus2}")
        video2.setVideoURI(offl)
        video2.setMediaController(mediaController1)
        video2.requestFocus()


        val kadr_res:RecyclerView=findViewById(R.id.kadr_view)
        kadr_res.adapter=kadr_adapter(this, kadrList().list)

        val pers_res:RecyclerView=findViewById(R.id.pers_view)
        pers_res.adapter=pers_adapter(this, Perslist().list2)

        tb=findViewById(R.id.toolbar)
        setSupportActionBar(this.tb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Клаус"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                val intent=Intent(this, homescreen::class.java)
                startActivity(intent)
                finish()
            }
            R.id.one -> {
                Toast.makeText(this, "работает", Toast.LENGTH_SHORT).show()
            }
            R.id.two -> {
                val inte=Intent(this, homescreen::class.java)
                startActivity(inte)
                finish()
            }
            R.id.three -> {
                val int=Intent(this, UserActivity::class.java)
                startActivity(int)
                finish()
            }
        }
        return true
    }
}