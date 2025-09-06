package com.example.testasgn.ui.userTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testasgn.R

@Composable
fun PersonalInfo(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "MEDICONNECT",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00C8B3))
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                modifier = Modifier
                    .size(28.dp)
                    .clickable { navController.navigate(Screen.EditProfile.route) }
                    ,
                tint = Color.Black,
            )

            Text(
                text = "Personal Info",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "Exit",
                modifier = Modifier.size(28.dp)
                    .clickable(){
                        navController.popBackStack()
                    },
                tint = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_photo),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        val viewModel: UserViewModel = viewModel()
        val personalInfo by viewModel.personalInfo.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.loadUserData()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                InfoItem("Name", personalInfo.name)
                InfoItem("Age", personalInfo.age)
                InfoItem("Date of Birth", personalInfo.dob)
                InfoItem("Gender", personalInfo.gender)
                InfoItem("Email Address", personalInfo.email)
                InfoItem("Address", personalInfo.address)
                InfoItem("Phone Number", personalInfo.phone)
                InfoItem("Medical History",
                    if (personalInfo.medicalHistory.isBlank()) "No medical history"
                    else personalInfo.medicalHistory
                )
            }
        }
    }
}