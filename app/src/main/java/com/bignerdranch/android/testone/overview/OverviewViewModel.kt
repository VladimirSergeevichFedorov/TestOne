package com.bignerdranch.android.testone.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.testone.network.TestApi
import com.bignerdranch.android.testone.network.UseData
//import com.bignerdranch.android.testone.room.Test
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel(){

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus> = _status

 //     Call getMarsPhotos() on init so we can display status immediately.

    private val _photos = MutableLiveData<List<UseData>>()
    val photos: LiveData<List<UseData>> = _photos

//    private val _email = MutableLiveData<List<Test>>()
//    var email: LiveData<List<Test>> = _email




//
//    private val _firstname = MutableLiveData<List<UseData>>()
//    val firstname: LiveData<List<UseData>> = _firstname
//
//    private val _lastname = MutableLiveData<List<UseData>>()
//    val lastname: LiveData<List<UseData>> = _lastname
    init {
        getUsers()
    }
    private fun getUsers() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _photos.value = TestApi.retrofitServise.getDataUser()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()

            }
        }
    }
    }
    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */


//${listResult.size}

//private fun getUsers() {
//    viewModelScope.launch {
//        try{
////            val listResult = TestApi.retrofitServise.getDataUser()
//            _status.value = "Success:  Mars photos retrieved"
//        } catch (e: Exception) {
//            _status.value = "Failure: ${e.message}"
//        }
//    }
//}

//app:listData="@{viewModel.photos}"