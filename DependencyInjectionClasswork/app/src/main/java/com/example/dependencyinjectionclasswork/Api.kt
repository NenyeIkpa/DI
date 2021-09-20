package com.example.dependencyinjectionclasswork

import com.example.dependencyinjectionclasswork.data.UserResponse
import com.example.dependencyinjectionclasswork.data.UserResponseItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {
        //Describe the request types and their relative URl
        @GET("users")
        fun fetchUser(): Call<UserResponse>

    }