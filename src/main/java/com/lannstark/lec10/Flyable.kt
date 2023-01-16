package com.lannstark.lec10

interface Flyable {

    // fun fly() // 추상 메서드 선언
    fun act() { // default 써주지 않아도 된다.
        println("파닥 파닥")
    }
}