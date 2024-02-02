package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

class activity_post : AppCompatActivity() {
lateinit var email:EditText
lateinit var pass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        email=findViewById(R.id.email)
        pass=findViewById(R.id.password)
    }

    fun enter(view: View) {
        if(email.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
            val log = retrofitobject2().getRetrofitObject2()
            val getApi=log.create(post_interface::class.java)
            val hashMap: HashMap<String, String> = HashMap()
            hashMap.put("email", email.text.toString())
            hashMap.put("password", pass.text.toString())
            val log_call:retrofit2.Call<data_model1> = getApi.getAuth(hashMap)
            log_call.enqueue(object:retrofit2.Callback<data_model1>{
                override fun onResponse(call: Call<data_model1>, response: Response<data_model1>) {
                    if(response.isSuccessful){
                        val int=Intent(this@activity_post, postenter::class.java)
                        startActivity(int)
                        finish()
                    }
                    else{
                        Toast.makeText(this@activity_post, "Такого пользователя в системе нет", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<data_model1>, t: Throwable) {
                    Toast.makeText(this@activity_post, t.message, Toast.LENGTH_SHORT).show()
                }})}
        else{
            Toast.makeText(this@activity_post, "Ошибка ввода", Toast.LENGTH_SHORT).show()
        }
    }
}