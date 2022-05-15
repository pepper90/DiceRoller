package com.jpdevzone.diceroller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jpdevzone.diceroller.R

class LandingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}