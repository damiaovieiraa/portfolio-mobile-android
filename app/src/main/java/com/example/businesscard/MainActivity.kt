package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Damião Vieira de Souza",
                        course = "Internet Systems Technologist",
                        tel = "83998820722",
                        email = "damiaovieira2002@gmail.com",
                        github = "github.com/damiaovieiraa"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    course: String,
    tel: String,
    email: String,
    github: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Cartão principal
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(350.dp)
                .background(Color.Black)
        ) {
            ParteSuperior(name, course)
            ParteInferior(tel, email, github)
        }
    }
}

@Composable
fun ParteSuperior(
    name: String,
    course: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Foto de Perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = course,
            fontSize = 14.sp,
            color = Color.LightGray,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun ParteInferior(
    tel: String,
    email: String,
    github: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        LinhaContato(R.drawable.ic_phone, tel)
        LinhaContato(R.drawable.ic_email, email)
        LinhaContato(R.drawable.ic_github, github)
    }
}

@Composable
fun LinhaContato(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
@Preview
fun PreviewBusinessCard() {
    BusinessCard(
            name = "Damião Vieira de Souza",
    course = "Internet Systems Technologist",
    tel = "83998820722",
    email = "damiaovieira2002@gmail.com",
    github = "github.com/damiaovieiraa"
    )
}
