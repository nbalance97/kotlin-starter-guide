package com.lannstark.lec11

/*
    1. 자바와 코틀린의 가시성 제어
        - 자바는 public, protected, default, private
        - 코틀린에서는 protected가 선언된 클래스 또는 하위 클래스에서 접근 가능(같은 패키지가 아님)
            - 코틀린에서는 기본적인 패키지를 Namespace를 관리하기 위한 용도로만 사용. 가시성 제어에는 사용하지 않습니다.
        - 코틀린에서는 default가 따로 존재하지 않습니다.
        - 코틀린에서는 internal이라는 지시어가 새로 생겼습니다. 같은 모듈 내에서만 접근 가능함을 의미합니다.
            - 모듈은 한번에 컴파일 되는 kotlin 코드입니다.
            - IDEA Module, Maven Project, Gradle Source Set 등
            - 모듈을 접근 제어하는 접근 제어자가 새로 생겼습니다.
        - public, private는 자바와 동일합니다.

        - 코틀린의 기본 접근 제어자는 public (자바는 default)
    2. 코틀린 파일의 접근 제어
        - 코틀린은 .kt 파일 내에 여러개의 변수, 함수, 클래스를 만들 수 있습니다.
        - 파일(최상단)의 접근 제어자는 기본적으로 public
        - protected는 파일(최상단)에서는 사용 불가능
        - internal은 같은 모듈
        - private는 현재 파일에서만

    3. 다양한 구성요소의 접근 제어
        1. 클래스 안의 멤버
        - public, protected, internal, private, 앞서 설명한 방식과 완전히 동일
        2. 생성자
        - 생성자에 접근 지시어를 써주려면 생성자를 직접 생성해야 합니다.
        - class Cat protected constructor ( ... ) { }
        - 위 예제같은경우는 하위 클래스를 못만드므로.. open을 써달라는 경고 발생

        - 자바의 유틸성 코드 -> abstract class + private constructor을 사용
        - 코틀린에서도 똑같이 짤 수 있지만, 파일 최상단에 써주는게 훨씬 편합니다.
        - 파일의 최상단 -> 바이트코드를 까보면 xxxKt 클래스 내에 정적 메소드(static 메서드)를 선언해준 것과 같습니다.
        - 자바에서도 xxxKt.메서드()로 사용할 수 있습니다.
        3. 프로퍼티
        - 가시성 범위는 동일합니다.
        - [val|var] 앞에 붙이면 getter과 setter를 한번에 지정 가능합니다.
        - [private|...] [set|get]을 사용하면 setter에 대해서만 가시성을 제어할 수 있습니다.

    4. Java와 Kotlin을 함께 사용할 경우 주의할 점
        - internal은 바이트 코드로 바꾸면 public이 됩니다.
        - 때문에 자바 코드에서는 Kotlin 모듈의 Internal 코드를 가져올 수 있습니다.
        - kotlin의 Protected는 java의 Protected와 다르므로 유의해야 합니다!!
 */

// protected val x = 0 // 파일(최상단)에서는 protected 사용시 컴파일 에러 발생

class Car(
    internal val name: String,
    private var owner: String,
    _price: Int
) {
    var price = _price
        private set
}

fun add(a: Int, b: Int): Int = a + b

fun main() {
    val x: Int? = null

    val data = x ?: 2
    val p = if (data == 2) 1 else 0
    print(p)
}