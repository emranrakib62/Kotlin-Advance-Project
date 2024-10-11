package com.example.viewpager2inandroidstudio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        pagerAdapter = ViewPagerAdapter()
        viewPager.adapter = pagerAdapter
    }
}

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    private val itemList = listOf(
        "Bangladesh is located in the north-eastern part of South Asia. " +
                "The majestic Himalayas stand some distance to the north, " +
                "while in the south lies the Bay of Bengal. West Bengal borders " +
                "on the west and in the east lies the hilly and forested regions " +
                "of Tripura, Mizoram (India), and Myanmar."
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.page_layout, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemList.size

    // ViewHolder class to bind data to the layout
    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pagerText: TextView = itemView.findViewById(R.id.pagerText)

        fun bind(item: String) {
            pagerText.text = item
        }
    }
}
