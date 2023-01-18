package com.lannstark.lec01

/*
    var number1 = 10L // 바꿀수 있는 변수는 var
    number1 = 10
    val number2 = 10L // 바꿀수 없는 변수는 val

    /*
    자바는 타입 작성, 코틀린은 타입을 작성해주지 않더라도 타입을 컴파일러가 추론
    원한다면 :(콜론) 이후 타입 작성 가능
     */
    var number3: Int = 10;

    // 변수를 만들고 초기값을 지정해 주지 않는 경우 무조건 타입 명시
    // var number1; // 컴파일러가 타입을 추론해줄 수 없어 에러 발생
    var number4: Int

    // val 컬렉션에는 element를 추가할 수 있다.
    // val 컬렉션 내부에 메서드를 사용하여 element 추가 가능
    // 모든 변수는 val로 만들고 필요에 따라 var로 바꿔준다.
 */

/*
    Kotlin에는 Primitive와 reference 타입 구분이 없음.
    숫자, 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현

    사실은 Long타입으로 합쳐져 있지만, 상황에 따라 코틀린이 내부적으로
    Primitive 타입으로 바꾸어서 처리해 준다.

    Tools - Kotlin - ByteCode 보기

    프로그래머가 boxing-unboxing 고려하지 않아도 되도록 코틀린이 알아서 처리
    자바의 boxing의 차이는 null 유무도 존재한다.
 */

fun main() {
    var number1: Long = 10L
    val number2: Long = 10L
    var number3: Long? = 1_000L // null이 들어갈 수 있다면 타입?으로 타입 지정
    val nums = 10L // 컴파일러가 자동으로 타입 추론해 줍니다.

    // 오른쪽에 일반적인 값이나 생성자가 들어가면 컴파일러가 hint로 타입 추론해주지는 않는 듯
    // 함수를 사용한 경우엔 타입 추론을 해주는 것 같음.

    val list = listOf(1, 2, 3)

    var person = Person("병훈") // 자바에서는 new 키워드를 사용하지만 코틀린은 new를 붙이지 않는다.
}