package com.example.databindingsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private var _count = MutableLiveData(0)
     val count: LiveData<Int> = _count



    fun updateCount() {
        _count.value = _count.value?.plus(1)
        Log.d("count", "updateCount: ${count.value}")
    }

}