package com.example.alertdialogboxinandroidstudio

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val showbutton:Button=findViewById(R.id.showbutton)

showbutton.setOnClickListener {
    showAlertdialogue()
}
    }
    private  fun showAlertdialogue(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Snapchat")
            .setMessage("Do you want to uninstall this app?")
            .setIcon(R.drawable.images)
            .setPositiveButton("yes"){dialog,which ->
                Toast.makeText(this,"The app is successfully uninstall",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){dialog,Which ->
               dialog.dismiss()
            }
        val alertDialog:AlertDialog=builder.create()
        alertDialog.show()
    }
}