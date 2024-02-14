package com.example.worldcinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class harryadapter(val con:Context, val list: MutableList<harry_model>):RecyclerView.Adapter<harryadapter.link3>() {
    class link3(view: View):RecyclerView.ViewHolder(view) {
        val name:TextView=view.findViewById(R.id.char_name)
        val fakul:TextView=view.findViewById(R.id.char_fak)
        val img:ImageView=view.findViewById(R.id.char_img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): link3 {
        val rr=LayoutInflater.from(con).inflate(R.layout.harry_item, parent, false)
        return link3(rr)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: link3, position: Int) {
        holder.name.setText(list[position].character)
        holder.fakul.setText(list[position].hogwartsHouse)
        Glide.with(con).load(list[position].image).into(holder.img)
    }
}