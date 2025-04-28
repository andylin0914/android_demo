package com.example.myapplication

import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class UmbrellaTest {
   // @Test
    //fun totalPrice(){
      //  val Umbrella = Umbrella()
       // val actual = Umbrella.totalPrice(5,200)
       // val expected = 900
       // Assert.assertEquals(expected, actual)
//    }

@Test
fun totalPrice_sunny(): Unit {
    val Umbrella = Umbrella()
    val stubweather =Stubweather()
    stubweather.fakeIsSunny = true
    val actual = Umbrella.totalPrice(5,200,stubweather)
    val expected = 1000
    Assert.assertEquals(expected, actual)
}
@Test
fun totalPrice_raining(){
 val Umbrella = Umbrella()
    val stubweather =Stubweather()
    stubweather.fakeIsSunny = false
 val actual = Umbrella.totalPrice(5,200,stubweather)
 val expected = 1000
Assert.assertEquals(expected, actual)
}

@Test
fun totalPrice_mockk_sunny(){
    val Umbrella = Umbrella()
    val weather =mockk<IWeather>()
    coEvery {weather.isSunny()} returns true
    val actual = Umbrella.totalPrice(5,200,weather)
    val expected = 900
    Assert.assertEquals(expected, actual)
}
}