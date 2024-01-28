package com.example.worldcinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class kadr_adapter(val con: Context, val list: ArrayList<kadr1>):RecyclerView.Adapter<kadr_adapter.Link>() {
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
val im: ImageView=itemView.findViewById(R.id.kadr1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kadr_adapter.Link {
        val root = LayoutInflater.from(con).inflate(R.layout.kadr_item,parent,false)
        return Link(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: kadr_adapter.Link, position: Int) {
        holder.im.setImageResource(list[position].imageId)
    }

}