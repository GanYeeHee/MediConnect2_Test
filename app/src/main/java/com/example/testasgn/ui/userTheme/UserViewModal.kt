// UserViewModel.kt
package com.example.testasgn.ui.userTheme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    private val _personalInfo = MutableStateFlow(Personal_Info())
    val personalInfo: StateFlow<Personal_Info> = _personalInfo

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun loadUserData() {
        viewModelScope.launch {
            try {
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val userSnapshot = db.collection("users")
                        .whereEqualTo("email", currentUser.email)
                        .get()
                        .await()

                    if (!userSnapshot.isEmpty) {
                        val userDoc = userSnapshot.documents[0]
                        val userData = Personal_Info(
                            userId = userDoc.id,
                            name = userDoc.getString("name") ?: "",
                            age = userDoc.getString("age") ?: "",
                            dob = userDoc.getString("dob") ?: "",
                            gender = userDoc.getString("gender") ?: "",
                            email = userDoc.getString("email") ?: "",
                            address = userDoc.getString("address") ?: "",
                            phone = userDoc.getString("phone") ?: "",
                            medicalHistory = userDoc.getString("medicalHistory") ?: "",
                            weight = userDoc.getString("weight") ?: "",
                            height = userDoc.getString("height") ?: "",
                            ic = userDoc.getString("ic") ?: ""
                        )
                        _personalInfo.value = userData
                        _isLoggedIn.value = true
                    }
                }
            } catch (e: Exception) {
                println("Error loading user data: ${e.message}")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            auth.signOut()
            _personalInfo.value = Personal_Info()
            _isLoggedIn.value = false
        }
    }

    fun updateUserData(updatedInfo: Personal_Info) {
        viewModelScope.launch {
            try {
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val userSnapshot = db.collection("users")
                        .whereEqualTo("email", currentUser.email)
                        .get()
                        .await()

                    if (!userSnapshot.isEmpty) {
                        val userDoc = userSnapshot.documents[0]
                        val updateData = mapOf(
                            "name" to updatedInfo.name,
                            "age" to updatedInfo.age,
                            "dob" to updatedInfo.dob,
                            "gender" to updatedInfo.gender,
                            "address" to updatedInfo.address,
                            "phone" to updatedInfo.phone,
                            "medicalHistory" to updatedInfo.medicalHistory,
                            "weight" to updatedInfo.weight,
                            "height" to updatedInfo.height,
                            "ic" to updatedInfo.ic
                        )
                        db.collection("users").document(userDoc.id)
                            .update(updateData)
                            .await()

                        _personalInfo.value = updatedInfo
                    }
                }
            } catch (e: Exception) {
                println("Error updating user data: ${e.message}")
            }
        }
    }
}