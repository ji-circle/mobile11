package com.example.fifthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fifthapp.ui.LoginPage
import com.example.fifthapp.ui.theme.FifthAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FifthAppTheme {
                LoginPage()
            }
        }
    }
}