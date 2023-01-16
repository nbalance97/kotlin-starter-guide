package com.lannstark.lec10

abstract class Animal(
    protected val species: String,
    open protected val legCount: Int
) {
    abstract fun move()
}