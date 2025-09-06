package com.example.testasgn.ui.userTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
fun Profile(navController: NavController) {
    val userViewModel: UserViewModel = viewModel()
    val personalInfo by userViewModel.personalInfo.collectAsState()

    // 加载用户数据
    LaunchedEffect(Unit) {
        userViewModel.loadUserData()
    }

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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0x591BC2B1),
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                )
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = personalInfo.name.ifEmpty { "User Name" },
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = personalInfo.address.ifEmpty { "No address provided" },
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "IC: ${personalInfo.ic.ifEmpty { "Not available" }}",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "   Info",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoColumn("Age", personalInfo.age.ifEmpty { "-" }, Modifier.weight(1f))
            InfoColumn("Weight", if (personalInfo.weight.isNotEmpty()) "${personalInfo.weight} kg" else "-", Modifier.weight(1f))
            InfoColumn("Height", if (personalInfo.height.isNotEmpty()) "${personalInfo.height} cm" else "-", Modifier.weight(1f))
        }


        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // Personal info
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.PersonaInfo.route) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        text = "Personal info",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(20.dp),
                    tint = Color.Black
                )
            }

            // History
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.History.route) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "History Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text("History", fontSize = 16.sp, color = Color.Black)
                }

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(20.dp),
                    tint = Color.Black
                )
            }

            // Bill
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.Bill.route) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Bill Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "Bill",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(20.dp),
                    tint = Color.Black
                )
            }

            // Setting
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.Setting.route) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Setting Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "Setting", fontSize = 16.sp, color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(20.dp),
                    tint = Color.Black
                )
            }

            // Logout
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.Logout.route) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "Logout Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "Logout", fontSize = 16.sp, color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(20.dp),
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .height(70.dp)
                .background(Color(0x2600C8B3), RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { navController.navigate(Screen.Appointment.route) }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Appointment",
                        modifier = Modifier.size(28.dp),
                        tint = Color.Gray
                    )
                    Text(
                        text = "Appointment",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { navController.navigate(Screen.MainMenu.route) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(28.dp),
                        tint = Color.Gray
                    )
                    Text(
                        text = "Home",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { navController.navigate(Screen.Profile.route) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(28.dp),
                        tint = Color(0xFF00C8B3)
                    )
                    Text(
                        text = "Profile",
                        fontSize = 12.sp,
                        color = Color(0xFF00C8B3),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}