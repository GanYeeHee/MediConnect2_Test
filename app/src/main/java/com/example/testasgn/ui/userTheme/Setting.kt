package com.example.testasgn.ui.userTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Setting(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
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

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        text = "",
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text("", fontSize = 16.sp, color = Color.Black)
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "",
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
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
                        imageVector = Icons.Default.Settings,
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(20.dp),
                        tint = Color.Black
                    )
                    Text(
                        "", fontSize = 16.sp, color = Color.Black
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
    }
}