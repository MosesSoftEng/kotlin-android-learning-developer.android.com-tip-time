package com.developer.android.tip.time

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup a click listener on the calculate button to calculate the tip
        val calculateButton: Button = findViewById(R.id.calculate_button);
        val costOfServiceEditText: EditText = findViewById(R.id.cost_of_service_edit_text);

//        calculateButton.setOnClickListener { calculateTip() }

//      Set up a key listener on the EditText field to listen for "enter" button presses
        costOfServiceEditText.setOnKeyListener {
                view, keyCode, _ ->  handleKeyEvent(view, keyCode)
        }
    }

    /**
     * Key listener for hiding the keyboard when the "Enter" button is tapped.
     */
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}