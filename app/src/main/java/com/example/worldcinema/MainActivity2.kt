package com.example.worldcinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    lateinit var pred: SharedPreferences
    lateinit var preff: SharedPreferences
    lateinit var mail:EditText
    lateinit var pass:EditText
    lateinit var check:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mail=findViewById(R.id.mailText)
        pass=findViewById(R.id.passText)
        pred=getSharedPreferences("Tablee", MODE_PRIVATE)
        preff=getSharedPreferences("Table", MODE_PRIVATE)
        check=findViewById(R.id.checkBox)
        check.isChecked=pred?.getBoolean("check", false)?:false
        mail.setText(pred?.getString("mail", ""))
        pass.setText(pred?.getString("pass", ""))
    }

    fun savecheck(check:Boolean){
        val editor=pred?.edit()
        editor?.putBoolean("check", check)
        editor?.apply()
    }

    fun savedata(mail:String, pass:String){
        val editor=pred?.edit()
        editor?.putString("mail", mail)
        editor?.putString("pass", pass)
        editor?.apply()
    }

    fun deleteAll(){
        val editor=pred?.edit()
        editor?.clear()
        editor?.apply()
    }


    fun signin(view: View) {
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
              if (mail.text.toString()==preff?.getString("mail", "") && pass.text.toString()==preff?.getString("pass", "")){
                    val value: String = mail.text.toString()
                    val value2: String = pass.text.toString()
                    val checkbox: Boolean = check.isChecked
                    if (checkbox==true) {
                        savedata(value, value2)
                        savecheck(checkbox)
                    } else {
                        deleteAll()
                    }
            val intent = Intent(this@MainActivity2, UserActivity::class.java)
                    startActivity(intent)
                    finish()
            } else {
                Toast.makeText(this, "Такой почты не существует или пароль неверный", Toast.LENGTH_SHORT).show()
             }
        } else {
            val alert=AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
                .show()

        }
    }
    fun signup(view: View) {
        val inten=Intent(this@MainActivity2, MainActivity3::class.java)
        startActivity(inten)
        finish()
    }

}