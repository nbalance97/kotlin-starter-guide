package com.lannstark.lec03

/*
    Kotlin의 Any는 Java의 Object

    instanceof의 걍우, Kotlin에서는 is를 사용합니다.
 */
fun main() {
    val person = Person("abcde", 15)

    printAgeIfPersonV1(person)
    printAgeIfPersonV2(person)
}

fun printAgeIfPersonV1(obj: Any) {
    if (obj is Person) {
        println(obj.age)
    }
}

fun printAgeIfPersonV2(obj: Any) = when(obj) {
    is Person -> println(obj.age)
    else -> {}
}

