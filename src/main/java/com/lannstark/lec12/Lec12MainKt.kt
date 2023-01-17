package com.lannstark.lec12

/*
    static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는것이 아닌 정적으로 인스턴스끼리의 값을 공유
    companion object : 클래스와 동행하는 유일한 오브젝트

    val MIN_AGE라는 변수에는 값이 런타임에 할당됩니다.
    const val MIN_AGE는 컴파일 시에 변수가 할당됩니다.
    const는 진정한 상수에 붙이기 위한 용도. 기본 타입 또는 String에만 붙일 수 있습니다.

    companion object(동반 객체) 또한 하나의 객체로 간주됩니다.
    - 따라서 인터페이스를 구현할 수도, 이름을 붙일 수도 있습니다.

    companion object에 유틸성 함수를 넣어도 되지만, 최상단 파일을 활용하는 것을 추천합니다.
    자바에서 코틀린 익명함수를 사용할 때
        - Person.Companion.newBaby("ABC") // 이름이 없는 경우 Companion
        - Person.newBaby("ABC")로 사용하기 위해선 newBaby 위에 @JvmStatic 어노테이션
        - 이름을 붙이는 경우에는 Person.이름.newBaby("ABC")
        - 자바에서 사용하려면 코틀린측에 @JvmStatic을 붙여준다면 자바에서 사용하듯이 사용 가능
        - 이름이 있다면 이름을 사용하면 됩니다.


    싱글톤
    - 단 하나의 인스턴스만을 갖는 클래스
    - 자바는 static 필드, enum 등등,,
    - 코틀린은 class 대신에 object 키워드를 붙여서 클래스를 선언하면 됩니다.
    - 실제 구현은 static 필드 + static 블록에서 초기화

    익명 클래스
    - 자바에서 일회성으로 new 인터페이스() { 인터페이스 구현 코드 }
    - 코틀린에서는 익명클래스 구현을 object : 인터페이스 타입 { 구현 코드 } 구문으로 사용합니다.

    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })

 */
fun main() {
    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}