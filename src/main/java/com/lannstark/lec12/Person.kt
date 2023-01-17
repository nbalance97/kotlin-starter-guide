package com.lannstark.lec12

class Person(
    var name: String,
    var age: Int
) {

//    companion object {
//        const val MIN_AGE = 1
//
//        fun newBaby(name: String): Person = Person(name, MIN_AGE)
//    }

    companion object Factory : Log { // 이름을 지을수도 있고, 인터페이스를 구현할 수도 있다.
        override fun log() {
            TODO("Not yet implemented")
        }
    }
}