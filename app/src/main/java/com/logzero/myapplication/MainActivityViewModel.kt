package com.logzero.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel()
{
    val TAG:String =MainActivityViewModel::class.java.name
    var result : MutableLiveData<String>? = null


    fun checkRandomNumber(): MutableLiveData<String>?
    {
        if(result==null)
        result = MutableLiveData()
        generateRandomNumber()
        return result
    }

    fun generateRandomNumber()
    {
        var randomNo = java.util.Random()
        result?.setValue("Random Number: " + randomNo.nextInt(10 - 1) + 1)
        Log.v(TAG,"Random Number: " + randomNo.nextInt(10 - 1) + 1)

    }

    override fun onCleared() {
        super.onCleared()
        Log.v(TAG,"DESTROY VIEWMODEL")
    }

}