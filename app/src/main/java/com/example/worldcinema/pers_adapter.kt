package com.example.worldcinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class pers_adapter(val con:Context, val list2: ArrayList<pers>):RecyclerView.Adapter<pers_adapter.Link2>() {
    class Link2(itemView: View):RecyclerView.ViewHolder(itemView) {
        val im: ImageView=itemView.findViewById(R.id.pers)
        val title: TextView=itemView.findViewById(R.id.name_pers)
        val subtitle: TextView=itemView.findViewById(R.id.opis_pers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pers_adapter.Link2 {
        val root = LayoutInflater.from(con).inflate(R.layout.pers_item,parent,false)
        return pers_adapter.Link2(root)
    }

    override fun getItemCount(): Int {
        return list2.size
    }

    override fun onBindViewHolder(holder: pers_adapter.Link2, position: Int) {
        holder.im.setImageResource(list2[position].imageId2)
        holder.title.setText(list2[position].title)
        holder.subtitle.setText(list2[position].subtitle)
    }
}