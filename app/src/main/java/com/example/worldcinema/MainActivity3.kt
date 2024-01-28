package com.example.worldcinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class MainActivity3 : AppCompatActivity() {
   var preff:SharedPreferences?=null
    lateinit var name: EditText
    lateinit var fam: EditText
    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var pass2: EditText


    val pattern = ("[a-z]{1,100}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        name = findViewById(R.id.editTextText)
        fam = findViewById(R.id.editTextText4)
        mail = findViewById(R.id.editTextText5)
        pass = findViewById(R.id.editTextText6)
        pass2 = findViewById(R.id.editTextText7)
        preff=getSharedPreferences("Table", MODE_PRIVATE)
    }

    fun savedata(name: String, fam: String, mail: String, pass: String){
        val editor=preff?.edit()
        editor?.putString("name", name)
        editor?.putString("fam", fam)
        editor?.putString("mail", mail)
        editor?.putString("pass", pass)
        editor?.apply()
    }

    fun emailValid(text: String): Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun ret(view: View) {
        val intent = Intent(this@MainActivity3, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }

    fun signup(view: View) {
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
            if (emailValid(mail.text.toString()) && pass.text.toString()==pass2.text.toString()) {
                val intent = Intent(this@MainActivity3, UserActivity::class.java)
                val name:String=name.text.toString()
                val fam:String=fam.text.toString()
                val mail:String=mail.text.toString()
                val pass:String=pass.text.toString()
                savedata(name, fam, mail, pass)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "ошибка при заполнении поля email, либо пароли не совпадают", Toast.LENGTH_SHORT).show()
            }
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}