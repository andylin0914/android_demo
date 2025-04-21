package com.example.myapplication

class Stubweather : IWeather {
var fakeIsSunny = false
    override fun isSunny() : Boolean {
        return fakeIsSunny
    }
}