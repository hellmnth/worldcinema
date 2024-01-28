package com.example.worldcinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class getadapter(val con:Context, val list: MutableList<data_model>):RecyclerView.Adapter<getadapter.link1>() {
    class link1(vi: View):RecyclerView.ViewHolder(vi) {
        val title_dii: TextView=vi.findViewById(R.id.titleget)
        val im_dii: ImageView = vi.findViewById(R.id.imageget)
        val text_dii: TextView = vi.findViewById(R.id.textget)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): link1 {
        val rri= LayoutInflater.from(con).inflate(R.layout.get_item, parent, false)
        return link1(rri)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: link1, position: Int) {
        holder.title_dii.setText(list[position].name)
        Glide.with(con).load(list[position].imageurl).into(holder.im_dii)
        holder.text_dii.setText(list[position].bio)

    }
}