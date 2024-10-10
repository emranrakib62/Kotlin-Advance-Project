package com.example.rakibvoicecallingapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class MainActivity : AppCompatActivity() {

    private lateinit var targetUserIdEditText: EditText
    private lateinit var myUserIdTextView: TextView
    private lateinit var voiceCallButton: ZegoSendCallInvitationButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        targetUserIdEditText = findViewById(R.id.targetuserid)
        myUserIdTextView = findViewById(R.id.myuseridText)
        voiceCallButton = findViewById(R.id.voicecallbutton)

        // Get user ID from the previous activity
        val myUserID = intent.getStringExtra("userId")  // The key must match
        myUserIdTextView.text = "Hi $myUserID,\nWhom do you want to call?"

        // Add TextWatcher to detect changes in target user ID input
        targetUserIdEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val targetUserID = s.toString().trim()
                if (targetUserID.isNotEmpty()) {
                    startVoiceCall(targetUserID)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed here
            }
        })
    }

    private fun startVoiceCall(targetUserID: String) {
        val targetUserName = targetUserID

        // Set up the voice call button for the call invitation
        voiceCallButton.setIsVideoCall(false) // Set to false for voice calls
        voiceCallButton.resourceID = "zego_uikit_call"  // Ensure this resource matches your configuration
        voiceCallButton.setInvitees(
            listOf(ZegoUIKitUser(targetUserID, targetUserName))  // Add target user to invitee list
        )
    }
}
