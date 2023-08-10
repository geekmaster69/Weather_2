package com.example.weather.mainModel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.common.entities.WeatherForecastEntity
import com.example.weather.mainModel.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    private val result = MutableLiveData<WeatherForecastEntity>()
    fun getResult(): LiveData<WeatherForecastEntity> = result

    private val snackBarMsg = MutableLiveData<Int>()
    fun getSnackBarMsg(): LiveData<Int> = snackBarMsg

    private val loader = MutableLiveData<Boolean>()
    fun isLoader(): LiveData<Boolean> = loader

    suspend fun getWeatherAndForecast(
        lat: Double,
        lng: Double,
        appId: String,
        exclude: String,
        units: String,
        lang: String,
    ) {
        viewModelScope.launch {
            try {
                loader.value = false
                val resultServer = repository.getWeatherAndForecast(lat, lng, appId, exclude, units, lang)
                result.value = resultServer

            } catch (e: Exception) {
                snackBarMsg.value = R.string.main_error_server

            } finally {
                loader.value = true
            }
        }
    }
}