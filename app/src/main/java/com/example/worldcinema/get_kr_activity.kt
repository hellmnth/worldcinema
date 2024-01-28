package com.example.worldcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class get_kr_activity : AppCompatActivity() {
    lateinit var rec:RecyclerView
    lateinit var adapter:getkradapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_kr)
        rec=findViewById(R.id.rec1)
        val ret=retrofitobject().getRetrofitObject()
        val inter=ret.create(get_interface::class.java)
        val retro_call: Call<MutableList<data_model>> = inter.getposter()
        retro_call.enqueue(object :retrofit2.Callback<MutableList<data_model>>{
            override fun onResponse(call: Call<MutableList<data_model>>, response: Response<MutableList<data_model>>) {
                adapter=getkradapter(baseContext, response.body() as MutableList<data_model>)
                rec.adapter=adapter
                Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<MutableList<data_model>>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        }
        )
    }
}