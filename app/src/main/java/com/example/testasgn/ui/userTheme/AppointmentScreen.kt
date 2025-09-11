package com.example.testasgn.ui.userTheme

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class Specialty(
    val name: String,
    val icon: ImageVector
)

val specialties = listOf(
    Specialty("Surgery", Icons.Default.Healing),
    Specialty("Internal Medicine", Icons.Default.MedicalServices),
    Specialty("Neurology", Icons.Default.AccountCircle),
    Specialty("Radiology", Icons.Default.CameraAlt),
    Specialty("Pediatrics", Icons.Default.ChildCare),
    Specialty("Orthopaedic", Icons.Default.Accessibility),
    Specialty("Urology", Icons.Default.Person),
    Specialty("Dermatology", Icons.Default.Face),
    Specialty("Hematology", Icons.Default.Bloodtype),
    Specialty("Endocrinology", Icons.Default.Science)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Make Appointment",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00C8B3),
                    titleContentColor = Color.White
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    var query by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search by specialty, doctor") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /* TODO: Specialty filter */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C8B3))
                        ) {
                            Text("Specialty", color = Color.White)
                        }
                        Button(
                            onClick = { /* TODO: Doctor filter */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C8B3))
                        ) {
                            Text("Doctor", color = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Select Specialty",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.Black
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(specialties) { specialty ->
                            SpecialtyCard(
                                specialty = specialty,
                                onClick = {
                                    // 修改這裡：使用 Screen.DoctorList 路由
                                    navController.navigate(Screen.DoctorList.createRoute(specialty.name))
                                }
                            )
                        }
                    }
                }

                // 底部導航欄保持不變
                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .background(Color(0x2600C8B3), RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                        .border(1.dp, Color(0xFF00C8B3), RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable { }
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Appointment",
                                modifier = Modifier.size(28.dp),
                                tint = Color(0xFF00C8B3)
                            )
                            Text(
                                text = "Appointment",
                                fontSize = 12.sp,
                                color = Color(0xFF00C8B3),
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
                                tint = Color.Gray
                            )
                            Text(
                                text = "Profile",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun SpecialtyCard(
    specialty: Specialty,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable(onClick = onClick),
        border = BorderStroke(1.dp, Color(0xFF00C8B3)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Icon(
                imageVector = specialty.icon,
                contentDescription = specialty.name,
                modifier = Modifier.size(32.dp),
                tint = Color(0xFF00C8B3)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = specialty.name,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = false,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun AppointmentScreenPreview() {
    MaterialTheme {
        AppointmentScreen(navController = rememberNavController())
    }
}