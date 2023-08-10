package com.example.weather.common.entities

data class Forecast(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>,
    val poo: Double,
    ): WeatherBase(dt, humidity, temp, weather)
