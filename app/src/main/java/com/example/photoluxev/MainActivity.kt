package com.example.photoluxev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import kotlin.math.log2

class MainActivity : AppCompatActivity() {

    private var inputLuxValue: Double = 0.0
    private lateinit var luxInputEditText: EditText
    private lateinit var exposureValueTextView: TextView
    private lateinit var luxConvertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link variables to main screen views
        luxInputEditText = findViewById(R.id.Input_lux_value_edit_text)
        exposureValueTextView = findViewById(R.id.Output_exposure_value_text_view)
        luxConvertButton = findViewById(R.id.lux_convert_button)
        // Convert button click listener
        luxConvertButton.setOnClickListener { luxConversion () }

    }
    // Function luxConversion: Converts a lux value to an EV (exposure value)
    private fun luxConversion () {

        val text: String = luxInputEditText.text.toString()
        // Check to confirm var inputLuxValue is a double
        if (text.isNotEmpty()) try {
            inputLuxValue = text.toDouble()
            // it means it is double
        } catch (e1: Exception) {
            // this means it is not double
            e1.printStackTrace()
        }
        // Divide inputLuxValue by 2.5
        val luxDivision: Double = inputLuxValue / 2.5
        // Convert luxDivision with log2 function to an EV (exposure value).
        val conversionResult: Double = log2(luxDivision)
        // Round conversionResult to 1 decimal place
        val roundedExposureValue = String.format("%.1f", conversionResult)
        exposureValueTextView.text = roundedExposureValue
    }


}