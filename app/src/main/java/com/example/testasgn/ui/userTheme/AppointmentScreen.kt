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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.random.Random

data class Specialty(
    val id: String,
    val name: String,
    val icon: ImageVector
)

val specialties = listOf(
    Specialty("surgery", "Surgery", Icons.Default.Healing),
    Specialty("internal_medicine", "Internal Medicine", Icons.Default.MedicalServices),
    Specialty("neurology", "Neurology", Icons.Default.AccountCircle),
    Specialty("radiology", "Radiology", Icons.Default.CameraAlt),
    Specialty("pediatrics", "Pediatrics", Icons.Default.ChildCare),
    Specialty("orthopaedic", "Orthopaedic", Icons.Default.Accessibility),
    Specialty("urology", "Urology", Icons.Default.Person),
    Specialty("dermatology", "Dermatology", Icons.Default.Face),
    Specialty("hematology", "Hematology", Icons.Default.Bloodtype),
    Specialty("endocrinology", "Endocrinology", Icons.Default.Science)
)

enum class ViewState {
    SPECIALTIES,
    DOCTORS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScreen(navController: NavController) {
    var query by remember { mutableStateOf("") }
    var currentViewState by remember { mutableStateOf(ViewState.SPECIALTIES) }
    var doctorQuery by remember { mutableStateOf("") }

    val filteredSpecialties = remember(query) {
        if (query.isBlank()) {
            specialties
        } else {
            specialties.filter { specialty ->
                specialty.name.contains(query, ignoreCase = true)
            }
        }
    }

    val shuffledDoctors = remember { sampleDoctors.shuffled() }

    val filteredDoctors = remember(doctorQuery) {
        if (doctorQuery.isBlank()) {
            shuffledDoctors
        } else {
            shuffledDoctors.filter { doctor ->
                doctor.name.contains(doctorQuery, ignoreCase = true) ||
                        doctor.specialty.contains(doctorQuery, ignoreCase = true) ||
                        doctor.languages.any { it.contains(doctorQuery, ignoreCase = true) }
            }
        }
    }

    val onSpecialtyButtonClick = {
        currentViewState = ViewState.SPECIALTIES
        query = ""
    }

    val onDoctorButtonClick = {
        currentViewState = ViewState.DOCTORS
        doctorQuery = ""
    }

    val onSpecialtyCardClick = { specialty: Specialty ->
        currentViewState = ViewState.DOCTORS
        doctorQuery = specialty.name
    }

    val onDoctorSelected = { doctor: Doctor ->
        navController.navigate(Screen.DoctorListScreen.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Make Appointment",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = onSpecialtyButtonClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentViewState == ViewState.SPECIALTIES) {
                                    Color(0xFF00C8B3)
                                } else {
                                    Color.White
                                }
                            )
                        ) {
                            Text(
                                "Specialty",
                                color = if (currentViewState == ViewState.SPECIALTIES) {
                                    Color.White
                                } else {
                                    Color.DarkGray
                                }
                            )
                        }

                        Button(
                            modifier = Modifier.border(1.dp, Color(0xFF00C8B3), RoundedCornerShape(40.dp)),
                            onClick = onDoctorButtonClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentViewState == ViewState.DOCTORS) {
                                    Color(0xFF00C8B3)
                                } else {
                                    Color.White
                                }
                            )
                        ) {
                            Text(
                                "Doctor",
                                color = if (currentViewState == ViewState.DOCTORS) {
                                    Color.White
                                } else {
                                    Color.DarkGray
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    when (currentViewState) {
                        ViewState.SPECIALTIES -> {
                            OutlinedTextField(
                                value = query,
                                onValueChange = { query = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = { Text("Search by specialty") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = "Search",
                                        tint = Color(0xFF00C8B3)
                                    )
                                },
                                trailingIcon = {
                                    if (query.isNotBlank()) {
                                        IconButton(onClick = { query = "" }) {
                                            Icon(
                                                Icons.Default.Close,
                                                contentDescription = "Clear search",
                                                tint = Color.Gray
                                            )
                                        }
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            if (query.isNotBlank()) {
                                Text(
                                    text = "Search results for \"$query\" (${filteredSpecialties.size} found)",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    color = Color.Gray
                                )
                            } else {
                                Text(
                                    text = "Select Specialty",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    color = Color.Black
                                )
                            }

                            if (filteredSpecialties.isEmpty() && query.isNotBlank()) {
                                // 无搜索结果
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(32.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "No results",
                                        modifier = Modifier.size(48.dp),
                                        tint = Color.LightGray
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = "No specialties found for \"$query\"",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Gray,
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "Try a different search term",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.LightGray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            } else {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(2),
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(12.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    items(filteredSpecialties) { specialty ->
                                        SpecialtyCard(
                                            specialty = specialty,
                                            onClick = { onSpecialtyCardClick(specialty) }
                                        )
                                    }
                                }
                            }
                        }

                        ViewState.DOCTORS -> {
                            OutlinedTextField(
                                value = doctorQuery,
                                onValueChange = { doctorQuery = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = { Text("Search by doctor name, specialty or languages") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = "Search",
                                        tint = Color(0xFF00C8B3)
                                    )
                                },
                                trailingIcon = {
                                    if (doctorQuery.isNotBlank()) {
                                        IconButton(onClick = { doctorQuery = "" }) {
                                            Icon(
                                                Icons.Default.Close,
                                                contentDescription = "Clear search",
                                                tint = Color.Gray
                                            )
                                        }
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            if (doctorQuery.isNotBlank()) {
                                Text(
                                    text = "Search results for \"$doctorQuery\" (${filteredDoctors.size} found)",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    color = Color.Gray
                                )
                            } else {
                                Text(
                                    text = "Available Doctors",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    color = Color.Black
                                )
                            }

                            if (filteredDoctors.isEmpty()) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(32.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "No doctors",
                                        modifier = Modifier.size(48.dp),
                                        tint = Color.LightGray
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = if (doctorQuery.isNotBlank()) {
                                            "No doctors found for \"$doctorQuery\""
                                        } else {
                                            "No doctors available"
                                        },
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Gray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            } else {
                                LazyColumn(
                                    verticalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    items(filteredDoctors) { doctor ->
                                        DoctorCard(
                                            doctor = doctor,
                                            navController = navController // 只传递必要的参数
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

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
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
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
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun DoctorCard(
    doctor: Doctor,
    navController: NavController // 移除 onSelect 参数
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Doctor Avatar",
                    modifier = Modifier.size(60.dp),
                    tint = Color(0xFF00C8B3)
                )

                Spacer(Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        doctor.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        ),
                        color = Color(0xFF333333)
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        "Specialty: ${doctor.specialty}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF666666),
                            fontSize = 14.sp
                        )
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        "Languages: ${doctor.languages.joinToString(", ")}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF666666),
                            fontSize = 14.sp
                        )
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        "Rating: ${doctor.rating}/5.0",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF666666),
                            fontSize = 14.sp
                        )
                    )
                }

                IconButton(
                    onClick = { /* TODO: Show doctor info */ },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Info",
                        tint = Color(0xFF00C8B3)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Divider(
                color = Color.LightGray.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = {
                    // 直接在这里处理导航
                    navController.navigate("confirm_booking/${doctor.id}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00C8B3)
                )
            ) {
                Text(
                    "Select Date",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
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