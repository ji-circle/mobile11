package com.example.fifthapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    goToRegisterPage: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    //여기 추가
    //현재 로그인되어있지 않은 상태면 여기 null이 들어감
    //아니면 해당 이메일이 여기 들어간다
    // 타입이 string이 아니라서 받으려면 따로 멤버변수 둬야함
    val currentUser = FirebaseAuth.getInstance().currentUser

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = "Login Page")
            })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "E-mail")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = goToRegisterPage
            ) {
                Text(text = "Register your email")
            }

            //onclick 부분 함수 넣음
            Button(
                modifier = Modifier.align(Alignment.End),
                onClick = { loginUser(email, password) }
            ) {
                Text(text = "Login")
            }

            //여기 추가...
            // currentUser.email이 String? 이기 떄문에 let 사용...
            // currentUser.email이 null이라면 let 안의 ㅅ이 텍스트 자체가 나타나질 않음
            (if (currentUser != null) currentUser.email else "No user")?.let {
                Text(
                    text = it,
                    style = typography.titleLarge
                )
            }
        }
    }
}

//추가
fun loginUser(email: String, password: String) {
    val auth = FirebaseAuth.getInstance()

    //여긴 signInWith임
    auth.signInWithEmailAndPassword(email, password)
}