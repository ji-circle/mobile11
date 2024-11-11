package com.example.fifthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fifthapp.ui.LoginPage
import com.example.fifthapp.ui.RegisterPage
import com.example.fifthapp.ui.theme.FifthAppTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        enableEdgeToEdge()
        setContent {
            FifthAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login",
                ) {
                    composable(route = "login") {
                        LoginPage(goToRegisterPage = {
                            navController.navigate(route = "register")
                        })
                    }

                    composable(route = "register") {
                        RegisterPage(backToLoginPage = {
                            navController.navigateUp()
                        })
                    }
                }
            }
        }
    }
}