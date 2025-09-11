package com.example.testasgn.ui.userTheme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.ceil

data class Doctor(
    val id: Int,
    val name: String,
    val specialty: String,
    val rating: Float,
    val languages: List<String>
)

val sampleDoctors = listOf(
    // Surgery
    Doctor(1, "Dr. Tan Wai Keat", "Surgery", 4.8f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(2, "Dr. Lim Kuan Seng", "Surgery", 4.9f, listOf("English", "Malay", "Mandarin")),
    Doctor(3, "Dr. Alex Koh Xin", "Surgery", 4.7f, listOf("English", "Cantonese")),

    // Internal Medicine
    Doctor(4, "Dr. Tan Jing Yi", "Internal Medicine", 4.6f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(5, "Dr. Chia Mei Xin", "Internal Medicine", 4.5f, listOf("English", "Malay", "Mandarin")),
    Doctor(6, "Dr. Alice Tan Jia Yi", "Internal Medicine", 4.8f, listOf("English", "Cantonese")),

    // Neurology
    Doctor(7, "Dr. John Ng Wei Ye", "Neurology", 4.7f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(8, "Dr. Lim Chu Zhi", "Neurology", 4.9f, listOf("English", "Malay", "Mandarin")),
    Doctor(9, "Dr. Elen Yap Jin Bing", "Neurology", 4.6f, listOf("English", "Cantonese")),

    // Radiology
    Doctor(10, "Dr. Kee Jun Wei", "Radiology", 4.5f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(11, "Dr. Ali Rahman", "Radiology", 4.8f, listOf("English", "Malay", "Mandarin", "Arabic")),
    Doctor(12, "Dr. Lee Ke Xin", "Radiology", 4.7f, listOf("English", "Malay", "Cantonese")),

    // Pediatrics
    Doctor(13, "Dr. Tang Kok Seng", "Pediatrics", 4.9f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(14, "Dr. Lim Yun", "Pediatrics", 4.8f, listOf("English", "Malay", "Mandarin")),
    Doctor(15, "Dr. Foo Mei Yan", "Pediatrics", 4.7f, listOf("English", "Cantonese")),

    // Orthopaedic
    Doctor(16, "Dr. Teo Mei Ching", "Orthopaedic", 4.8f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(17, "Dr. Loh Yu Jia", "Orthopaedic", 4.6f, listOf("English", "Malay", "Mandarin")),
    Doctor(18, "Dr. Michael Chong Hao Yee", "Orthopaedic", 4.7f, listOf("English", "Cantonese")),

    // Urology
    Doctor(19, "Dr. Sam Lee", "Urology", 4.5f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(20, "Dr. Ong Wei Jie", "Urology", 4.8f, listOf("English", "Malay", "Mandarin")),
    Doctor(21, "Dr. Annad Raj", "Urology", 4.6f, listOf("English", "Hindi", "Cantonese")),

    // Dermatology
    Doctor(22, "Dr. Tan Wei Ming", "Dermatology", 4.7f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(23, "Dr. Lim Jia Hui", "Dermatology", 4.9f, listOf("English", "Malay", "Mandarin")),
    Doctor(24, "Dr. Alex Wong", "Dermatology", 4.8f, listOf("English", "Cantonese")),

    // Hematology
    Doctor(25, "Dr. Sarah Chen", "Hematology", 4.6f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(26, "Dr. David Tan", "Hematology", 4.7f, listOf("English", "Malay", "Mandarin")),
    Doctor(27, "Dr. Lisa Koh", "Hematology", 4.5f, listOf("English", "Cantonese")),

    // Endocrinology
    Doctor(28, "Dr. Robert Teo", "Endocrinology", 4.8f, listOf("English", "Malay", "Mandarin", "Cantonese")),
    Doctor(29, "Dr. Michelle Lim", "Endocrinology", 4.9f, listOf("English", "Malay", "Mandarin")),
    Doctor(30, "Dr. Kevin Yap", "Endocrinology", 4.7f, listOf("English", "Cantonese"))
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorListScreen(
    navController: NavController,
    specialty: String = "",
    doctors: List<Doctor> = sampleDoctors,
    onRefresh: () -> Unit = {},
    onDoctorSelected: (Doctor) -> Unit = {}
) {
    val filteredDoctors = sampleDoctors.filter { it.specialty == specialty }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Doctors - $specialty",
                        color = Color.White
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
                    containerColor = Color(0xFF00C8B3)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "$specialty Doctors (${filteredDoctors.size})",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color(0xFF00C8B3),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onRefresh,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        tint = Color(0xFF00C8B3)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            var query by remember { mutableStateOf("") }
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = { Text("Search by Doctor Name, Languages") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFF00C8B3),
                    unfocusedIndicatorColor = Color.LightGray,
                    focusedLeadingIconColor = Color(0xFF00C8B3),
                    unfocusedLeadingIconColor = Color.Gray
                )
            )

            Spacer(Modifier.height(16.dp))

            if (filteredDoctors.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "No doctors found for $specialty",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                    Text(
                        "Please check back later",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray,
                        modifier = Modifier.padding(top = 8.dp)
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
                            onSelect = { onDoctorSelected(doctor) }
                        )
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            if (filteredDoctors.isNotEmpty()) {
                PaginationBar(
                    totalPages = ceil(filteredDoctors.size / 5.0).toInt(), // 每頁5個醫生
                    currentPage = 1,
                    onPageClick = {}
                )
            }
        }
    }
}

@Composable
fun DoctorCard(
    doctor: Doctor,
    onSelect: () -> Unit
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
                onClick = onSelect,
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

@Composable
fun PaginationBar(totalPages: Int, currentPage: Int, onPageClick: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalPages) { index ->
            val page = index + 1
            OutlinedButton(
                onClick = { onPageClick(page) },
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(8.dp),
                colors = if (page == currentPage)
                    ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0xFF00C8B3),
                        contentColor = Color.White
                    )
                else
                    ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF00C8B3)
                    ),
                border = BorderStroke(
                    1.dp,
                    if (page == currentPage) Color.Transparent else Color(0xFF00C8B3)
                )
            ) {
                Text(
                    page.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorListScreenPreview() {
    DoctorListScreen(
        navController = rememberNavController(),
        specialty = "General Practitioner",
        doctors = sampleDoctors.take(5)
    )
}