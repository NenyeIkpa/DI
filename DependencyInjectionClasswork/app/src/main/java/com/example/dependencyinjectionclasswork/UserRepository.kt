package com.example.dependencyinjectionclasswork

import com.example.dependencyinjectionclasswork.data.UserResponse
import retrofit2.Call
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: Api) {
     fun fetchUser(): Call<UserResponse> {
         return api.fetchUser()
     }
}