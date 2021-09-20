package com.example.dependencyinjectionclasswork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint      //tells Hilt which classes to provide dependencies to
class MainActivity: AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeUserResponse()
    }

    private fun observeUserResponse() {
        userViewModel.fetchUserList.observe(this, {
            if (it != null) {
                Log.d("User","$it ")
            }
        })
        userViewModel.fetchUserData()
    }
}