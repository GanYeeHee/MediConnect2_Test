package com.example.testasgn.ui.userTheme

sealed class Screen(val route: String) {
    object MainMenu : Screen("main_menu")
    object Appointment : Screen("appointment")
    object MedicalReminder : Screen("medical_reminder")
    object Profile : Screen("profile")
    object PersonaInfo : Screen("personal_info")
    object History : Screen("history")
    object Bill : Screen("bill")
    object Setting : Screen("setting")
    object Logout : Screen("logout")
    object EditProfile : Screen ("edit profile")
    object DoctorList : Screen("doctor_list/{specialty}") {
        fun createRoute(specialty: String) = "doctor_list/$specialty"
    }
    object DoctorListScreen : Screen("doctor lidt")
    object ConfirmBookingScreen : Screen("confirm")
}
