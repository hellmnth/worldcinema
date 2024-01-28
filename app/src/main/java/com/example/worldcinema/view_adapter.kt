package com.example.worldcinema

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class view_adapter(fa: Fragment4, private val list:List<Fragment>):FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}