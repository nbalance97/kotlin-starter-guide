package com.lannstark.lec10

class Cat(
    species: String
) : Animal(species, 4) { // 컨벤션 : 좌우로 띄어주며, Animal의 생성자를 사용합니다.

    override fun move() { // 어노테이션이 아닌 지시어 override를 사용합니다.
        TODO("Not yet implemented")
    }
}