package com.example.recyclerviewinandroidstudiousingkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var datalist: ArrayList<DataClass>
    lateinit var imagelist:Array<Int>
    lateinit var titlelist:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
imagelist= arrayOf(
    R.drawable.ic_list,
    R.drawable.ic_checkbox,
    R.drawable.ic_camera,
    R.drawable.ic_date,
    R.drawable.ic_rating,
    R.drawable.ic_text,
    R.drawable.ic_time,
    R.drawable.ic_edit,
    R.drawable.ic_image

)
        titlelist= arrayOf(
             "Listview",
             "Cheakbox",
             "Camera",
             "Date Picker",
             "Rating Bar",
             "Textview",
             "Time Picker",
             "Edittext",
             "Imageview",
        )
        recyclerView=findViewById(R.id.recyclearview)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        datalist= arrayListOf<DataClass>()
        getData()
    }
    private fun getData(){
for(i in imagelist.indices){
    val dataClass=DataClass(imagelist[i],titlelist[i])
    datalist.add(dataClass)
}
        recyclerView.adapter=AdapterClass(datalist)
    }
}