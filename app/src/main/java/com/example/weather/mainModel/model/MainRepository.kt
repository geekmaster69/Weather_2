package com.example.weather.mainModel.model

import com.example.weather.common.entities.WeatherForecastEntity

class MainRepository {
    private val remoteDatabase = RemoteDatabase()

    suspend fun getWeatherAndForecast(
        lat: Double,
        lng: Double,
        appId: String,
        exclude: String,
        units: String,
        lang: String,
    ): WeatherForecastEntity =
        remoteDatabase.getWeatherForecastByCoordinates(lat, lng, appId, exclude, units, lang)
}