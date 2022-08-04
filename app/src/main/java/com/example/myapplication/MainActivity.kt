package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.thedeanda.lorem.LoremIpsum

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)
        val prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        if (prefs.getInt(COUNT_KEY, 0) > 1) {
            text.text = LoremIpsum.getInstance().getWords(5, 10)
        }

    }
}