package com.example.bottomnavigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomnavigationview:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomnavigationview=findViewById(R.id.bottom_navigation)
bottomnavigationview.setOnItemSelectedListener {menuitem ->
   when(menuitem.itemId){
       R.id.bottom_home ->{
           replacefragment(HomeFragment())
           true
       }
       R.id.bottom_search ->{
           replacefragment(SearchFragment())
           true
       }

       R.id.bottom_add ->{
           Toast.makeText(this,"upload image and vedio",Toast.LENGTH_SHORT).show()

           true
       }
       R.id.bottom_profile ->{
           replacefragment(ProfileFragment())
           true
       }
       else ->false

   }

}

        replacefragment(HomeFragment())
    }
    private fun replacefragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}