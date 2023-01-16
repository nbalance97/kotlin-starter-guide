package com.lannstark.lec10

class PenguinImpl(
    species: String
) : Animal(species = species, legCount = 2), Swimable, Flyable {

    private val wingCount = 2

    override fun move() {
        println("뒤뚱뒤뚱")
    }

    override val legCount: Int // property의 경우, open을 붙여주지 않으면 오버라이드 할 수 없다.
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act() // Java에서는 Swimable.super.act()
    }
}