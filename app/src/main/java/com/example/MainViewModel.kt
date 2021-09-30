package com.example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutineex.data

class MainViewModel : ViewModel() {
    private val Text : MutableLiveData<List<data>>by lazy {
        MutableLiveData<List<data>>().also{
            loadText()
        }
    }

    private fun loadText(){
        
        val t1 = run {
            val text = "1번"
            data(text)
        }
        val t2 = run {
            val text = "2번"
            data(text)
        }
        val t3 = run {
            val text = "3번"
            data(text)
        }
    }
}