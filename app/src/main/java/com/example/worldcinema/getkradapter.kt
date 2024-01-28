package com.example.worldcinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class getkradapter(val cont:Context,val list2: MutableList<data_model>): RecyclerView.Adapter<getkradapter.link2>() {
    class link2(view:View):RecyclerView.ViewHolder(view) {
        val team_di:TextView=view.findViewById(R.id.film)
        val realname_di:TextView=view.findViewById(R.id.realname)
        val img_di:ImageView=view.findViewById(R.id.hero)
        val comics_di:TextView=view.findViewById(R.id.comics)
        val date_di:TextView=view.findViewById(R.id.date)
        val author_di:TextView=view.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): link2 {
        val rr= LayoutInflater.from(cont).inflate(R.layout.get_kr_item, parent, false)
        return link2(rr)
    }

    override fun getItemCount(): Int {
        return list2.size
    }

    override fun onBindViewHolder(holder: link2, position: Int) {
        holder.team_di.setText(list2[position].team)
        Glide.with(cont).load(list2[position].imageurl).into(holder.img_di)
        holder.realname_di.setText(list2[position].realname)
        holder.comics_di.setText(list2[position].publisher)
        holder.date_di.setText(list2[position].firstappearance)
        holder.author_di.setText(list2[position].createdby)
    }
}