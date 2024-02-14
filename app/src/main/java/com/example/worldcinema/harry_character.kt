package com.example.worldcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class harry_character : AppCompatActivity() {
    lateinit var rec: RecyclerView
    lateinit var adapter:harryadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.harry_character)
        rec=findViewById(R.id.harry_rec)
        val ret=harryobject().getHarryObject()
        val inter=ret.create(harry_interface::class.java)
        val retro_call: Call<MutableList<harry_model>> = inter.getharry()
        retro_call.enqueue(object : retrofit2.Callback<MutableList<harry_model>>{
            override fun onResponse(
                call: Call<MutableList<harry_model>>,
                response: Response<MutableList<harry_model>>
            ) {
                adapter=harryadapter(baseContext, response.body() as MutableList<harry_model>)
                rec.adapter=adapter
                Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<MutableList<harry_model>>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}