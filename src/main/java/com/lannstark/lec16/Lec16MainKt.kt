package com.lannstark.lec16
/*
    코틀린에서 다양한 함수를 다루는 방법
    1. 확장함수
        - 기존 자바 코드 위에 자연스럽게 코틀린 코드를 추가할 방법
        - Java로 만들어진 라이브러리를 유지보수, 확장할 때 코틀린 코드를 덧붙이고 싶은 경우
        - 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자.
        - 클래스 안에 있는 멤버함수처럼 호출할 수 있는 밖에 있는 함수

        - fun 확장클래스.함수명(파라미터): 리턴타입 -> 클래스를 확장
        - this를 이용하여 실제 클래스 내부의 값에 접근
        - 이 때의 this를 수신 객체라고 부르며, 확장클래스를 수신객체 타입이라고 부릅니다.
        - 원래 클래스에 있는 함수처럼 사용할 수 있다.

        1. 확장함수가 public이고, 수신객체클래스의 private 함수를 가져온다면 캡슐화가 깨지는 것이 아닐까?
            - 애당초 확장함수에서는 클래스의 Private 또는 protected 멤버를 가져올 수 없다.
        2. 멤버함수와 확장함수의 시그니처가 같다면?
            - 확장함수와 멤버함수의 시그니처가 같다면 멤버함수가 우선적으로 호출됩니다.
            - 확장함수를 만들었지만, 똑같은 멤버함수가 생긴다면 오류가 발생할 수 있습니다.
        3. 확장함수가 오버라이드 된다면?
            - Train을 Srt가 상속받는다고 하고, Train과 Srt 모두 확장 함수가 정의되어있다고 할 때,
            - 해당 변수의 현재 타입(정적인 타입)에 의해 어떤 확장함수가 호출될 지 결정됩니다.
            - train: Train -> Train의 확장함수
            - train: Srt -> Srt의 확장함수

        - 자바에서는 코틀린에 존재하는 확장함수를 정적 메소드를 부르는 것처럼 사용 가능합니다.
        - 확장함수라는 개념은 확장프로퍼티와도 연결됩니다.
            - 확장 프로퍼티의 원리는 확장함수 + custom getter와 동일합니다.

            val String.lastChar: Char
                get() = this[this.length - 1]


    2. infix 함수
        - downTo, step도 함수입니다.
        - 변수.함수이름(argument) 대신 "변수 함수이름 argument"
        - Infix는 멤버함수에도 붙일 수 있습니다.
        - infix fun Int.add2(other: Int): Int = this + other // 3.add2(4) == 3 add2 4

    3. inline 함수
        - 함수를 호출한 지점에 함수 본문을 그대로 복사하고 싶은 경우
        - 함수를 파라메터로 전달할 때 오버헤드를 줄일 수 있습니다.
        - 성능 측정과 함께 신중하게 사용되어야 합니다.
        - 코틀린 라이브러리는 최적화가 되어있어 이미 적절하게 inline이 붙어있습니다.
        - 바이트 코드를 확인

    4. 지역함수
        - 함수 안에서 함수를 선언합니다.
        - 함수로 추출하면 좋을것 같지만, 함수를 지금 함수 내에서만 사용하고 싶은 경우
        - 뎁스가 깊어지기도 하고, 코드가 그렇게 깔끔하지도 않다.
        - 위치를 조정해주는 편이 훨씬 나을 가능성이 높다.
 */

fun createPerson(firstName: String, lastName: String): Person {
    fun validate(name: String) = if (name.isEmpty()) { throw IllegalArgumentException() } else {}

    validate(firstName)
    validate(lastName)

    return Person(firstName, lastName, 1)
}


inline fun Int.add(other: Int): Int { // inline은 바이트 코드 변환해서 봤을때 코드 자체가 복붙된다.
    return this + other
}

infix fun Int.add2(other: Int): Int = this + other // 3.add2(4) == 3 add2 4

fun String.lastChar(): Char { // 확장함수
    return this[this.length - 1]
}

fun main() {
    val last = "abc".lastChar()

    println(last)
    test().hello()

    val train: Train = Train()
    val srt: Srt = Srt()
    val srtTrain: Train = Srt()

    train.move()
    srt.move()
    srtTrain.move()
}

fun test.hello() {
    println("hello world!")
}

class test {
    fun hello() {

    }
}

open class Train

class Srt : Train()

fun Train.move() {
    println("train move")
}

fun Srt.move() {
    println("Srt move")
}
