package com.example.fifthapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fifthapp.ui.theme.FifthAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage() {
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
                //아래것들 바깥으로 패딩 주기
                .padding(16.dp)
        ) {
            //텍스트필드 2개와 버튼 하나 생성 - 로그인 정보 입력할부분
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "E-mail")
                }
            )
            //텍스트필드 간 공백 주기
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Password")
                }
            )
            //텍스트필드-버튼 간 공백 주기
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                //버튼 위치를 오른쪽으로 보냈다
                modifier = Modifier.align(Alignment.End),
                onClick = {}
            ) {
                Text(text = "Login")
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FifthAppTheme {
        Greeting("Android")
    }
}