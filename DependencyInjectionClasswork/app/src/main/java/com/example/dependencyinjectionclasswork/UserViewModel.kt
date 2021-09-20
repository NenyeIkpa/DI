package com.example.dependencyinjectionclasswork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionclasswork.data.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val repo: UserRepository
): ViewModel() {

    private  val _fetchUserList: MutableLiveData<UserResponse?> = MutableLiveData()
    val fetchUserList: LiveData<UserResponse?> = _fetchUserList

    fun fetchUserData() {
        repo.fetchUser().enqueue(object : retrofit2.Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    _fetchUserList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    _fetchUserList.postValue(null)

            }


        })
    }
}