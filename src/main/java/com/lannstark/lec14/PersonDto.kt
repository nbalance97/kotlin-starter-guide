package com.lannstark.lec14

fun main() {
    val dto1 = PersonDto("abc", 10)
    val dto2 = PersonDto("abc", 10)

    println(dto1 == dto2)
    println(dto1.hashCode())
    println(dto1)
}

data class PersonDto(
    val name: String,
    val age: Int
)