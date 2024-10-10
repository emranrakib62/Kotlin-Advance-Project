package com.example.listviewinandroidstudiousingkotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val listview=findViewById<ListView>(R.id.listview)
        val listItem= arrayOf("Read a Book",
            "Create a Project",
            "Learn Kotlin",
            "Go for Shopping",
            "attend a Seminar")

        val listAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem)
        listview.adapter=listAdapter
        listview.setOnItemClickListener{parent,view,position,id ->
        val selectedItem=parent.getItemAtPosition(position) as String
            Toast.makeText(this,"You Have Clicked On: $selectedItem",Toast.LENGTH_SHORT).show()

        }
    }
}