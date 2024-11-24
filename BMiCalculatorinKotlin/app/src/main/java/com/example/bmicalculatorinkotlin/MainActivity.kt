package com.example.bmicalculatorinkotlin



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.bmicalculatorinkotlin.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a click listener on the calculate button
        binding.cal.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        // Retrieve user inputs
        val weight = binding.weightedit.text.toString().toFloatOrNull()
        val height = binding.heightedit.text.toString().toFloatOrNull()

        // Check if inputs are valid
        if (weight != null && height != null && height > 0) {
            val bmi = weight / (height / 100).pow(2) // Height converted to meters
            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi in 18.5..24.9 -> "Normal weight"
                bmi in 25.0..29.9 -> "Overweight"
                else -> "Obese"
            }
            val result = String.format("BMI: %.2f\nCategory: %s", bmi, bmiCategory)

            // Display the result in the TextView
            binding.tv.text = result
        } else {
            // Show a warning if inputs are invalid
            Toast.makeText(this, "Please enter valid weight and height!", Toast.LENGTH_SHORT).show()
        }
    }
}
