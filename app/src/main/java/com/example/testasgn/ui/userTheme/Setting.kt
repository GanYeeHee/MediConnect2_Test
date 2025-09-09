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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import android.content.Intent
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Setting(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            var showTutorialDialog by remember { mutableStateOf(false) }
            SettingItem(
                icon = Icons.Default.Book,
                title = "User Guide",
                description = "How to use the app",
                onClick = { showTutorialDialog = true }
            )

            if (showTutorialDialog) {
                TutorialDialog(onDismiss = { showTutorialDialog = false })
            }

            Spacer(modifier = Modifier.height(12.dp))

            SettingItem(
                icon = Icons.Default.Share,
                title = "Share App",
                description = "Share with friends and family",
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Check out MediConnect app - Your healthcare companion!"
                    )
                    context.startActivity(
                        Intent.createChooser(
                            shareIntent,
                            "Share MediConnect"
                        )
                    )
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            var showAppInfoDialog by remember { mutableStateOf(false) }
            SettingItem(
                icon = Icons.Default.Info,
                title = "App Information",
                description = "Version and app details",
                onClick = { showAppInfoDialog = true }
            )

            if (showAppInfoDialog) {
                AppInfoDialog(onDismiss = { showAppInfoDialog = false })
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Version 1.0.0",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TutorialDialog(onDismiss: () -> Unit) {
    val alertDialog = AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("How to Use MediConnect") },
        text = {
            Column {
                Text("1. 📅 Make appointments with doctors", fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(4.dp))
                Text("2. ⏰ Set medical reminders", fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(4.dp))
                Text("3. 👤 Manage your personal health profile", fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(4.dp))
                Text("4. 📋 View your medical history", fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(8.dp))
                Text("For more help, contact support.", fontSize = 14.sp, color = Color.Gray)
            }
        },
        confirmButton = {
            androidx.compose.material3.TextButton(
                onClick = onDismiss
            ) {
                Text("Got it!")
            }
        }
    )
}

@Composable
fun AppInfoDialog(onDismiss: () -> Unit) {
    val alertDialog = AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("App Information") },
        text = {
            Column {
                Text("MediConnect v1.0.0", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("A healthcare companion app for managing your medical needs.")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Developed as a student project.")
            }
        },
        confirmButton = {
            androidx.compose.material3.TextButton(
                onClick = onDismiss
            ) {
                Text("OK")
            }
        }
    )
}

@Composable
fun SettingItem(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 16.dp),
                tint = Color(0xFF00C8B3)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingPreview() {
    Setting(navController = rememberNavController())
}