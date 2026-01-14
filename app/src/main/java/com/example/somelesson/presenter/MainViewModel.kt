package com.example.somelesson.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.somelesson.domain.SetColorUseCase
import com.example.somelesson.domain.SetStateUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val setStateUseCase: SetStateUseCase,
    private val setColorUseCase: SetColorUseCase
): ViewModel() {

    private var recurringJob: Job? = null;

    fun turnOnLamp(){
        viewModelScope.launch {
            setStateUseCase(isOn = true)
        }
    }

    fun turnOffLamp(){
        viewModelScope.launch {
            setStateUseCase(isOn = false)
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            val response = setColorUseCase(color)
        }
    }

    fun enablePoliceJob() {
        if(recurringJob?.isActive == true)
            recurringJob?.cancel()

        recurringJob = viewModelScope.launch {
            val delayMilliseconds = 500L

            while(true) {
                delay(delayMilliseconds)
                setColorUseCase("blue")
                delay(delayMilliseconds)
                setColorUseCase("red")
            }
        }
    }

    fun enableSuppressorJob() {
        if(recurringJob?.isActive == true)
            recurringJob?.cancel()

        recurringJob = viewModelScope.launch {
            while(true) {
                delay(10)
                launch {
                    setStateUseCase(isOn = false)
                }
            }
        }
    }

    fun stopRecurringJob() {
        recurringJob?.cancel()
    }
}