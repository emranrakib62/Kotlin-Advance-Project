package com.example.explicitintentandimplicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val explicit=findViewById<Button>(R.id.explicit)
        explicit.setOnClickListener {
            val explicit=Intent(this,SecondActivity::class.java)
            startActivity(explicit)
            finish()
        }

        val url="https://www.google.com/"
        val implicit=findViewById<Button>(R.id.implicit)

        implicit.setOnClickListener {
      val implicitIntent=Intent(Intent.ACTION_VIEW, Uri.parse(url))
          startActivity(implicitIntent)
        }
    }
}