package com.example.fragmentinandroidstudio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentinandroidstudio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var fragmatmanager:FragmentManager
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonfragment1.setOnClickListener {
            gotofragment(Fragment1())

        }

        binding.buttonfragment2.setOnClickListener{
            gotofragment(Fragment2())

        }


    }
    private  fun gotofragment(fragment: Fragment){
        fragmatmanager=supportFragmentManager
        fragmatmanager.beginTransaction().replace(R.id.fragmentcontainer,fragment).commit()
    }
}