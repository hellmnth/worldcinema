package com.example.worldcinema

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Fragment4 : Fragment() {
    lateinit var tl: TabLayout
    lateinit var vp: ViewPager2
    private val fraglist = listOf(Fragment1(), Fragment2(), Fragment3())
    private val tablist = listOf("В тренде", "Новинки", "Для вас")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val root =inflater.inflate(R.layout.fragment4, container, false)
         tl=root.findViewById(R.id.tablay)
        vp = root.findViewById(R.id.fragment_holder)
        val adapter = view_adapter(this, fraglist)
        vp.adapter = adapter
        TabLayoutMediator(tl, vp) { tab, pos ->
            tab.text = tablist[pos]
        }.attach()
        vp.isSaveEnabled=false

return root


    }
}