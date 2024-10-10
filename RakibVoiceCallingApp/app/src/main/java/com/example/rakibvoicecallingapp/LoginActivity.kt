package com.example.rakibvoicecallingapp

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class LoginActivity : AppCompatActivity() {

    private lateinit var userIdEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize UI components
        userIdEditText = findViewById(R.id.myuserid)
        loginButton = findViewById(R.id.logbutton)

        // Set login button click listener
        loginButton.setOnClickListener {
            val userId = userIdEditText.text.toString().trim()

            if (userId.isNotEmpty()) {
                // Start MainActivity with the provided user ID
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("userId", userId)
                startActivity(intent)

                // Initialize Zego UI Kit for calling service
                setupZegoUIkit(userId)
            }
        }
    }

    private fun setupZegoUIkit(userID: String) {
        val application: Application = application
        val appID: Long = 123L  // Replace with your actual App ID
        val appSign: String = "456"  // Replace with your actual App Sign
        val userName: String = userID

        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()

        // Initialize Zego Call Service
        ZegoUIKitPrebuiltCallService.init(application, appID, appSign, userName, userID, callInvitationConfig)
    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallService.unInit()
    }
}
