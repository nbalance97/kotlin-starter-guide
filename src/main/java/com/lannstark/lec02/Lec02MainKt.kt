package com.lannstark.lec02

/*
    kotlin에서는 null 체크를 어떻게 할까?
    - 코틀린에서는 null 가능 타입을 완전히 다르게 취급
    - null이 가능한 타입(?)만을 위한 기능은 없을까?

    Safe Call과 Elvis 연산자
    - Safe Call : String? 타입에 대하여 str?.length같이 메소드 호출
    - null이 아니면 호출하고, null인 경우 전체가 null이 된다.

    - Elvis 연산자 : str?.length ?: 0
    - 앞의 연산 결과가 null이면 뒤의 값을 사용합니다.
    - TMI) 엘비스라는 가수의 스타일과 닮아서..
    - Elvis 연산자를 활용하여 Early Return이 가능합니다.
      - v ?: return false

    Null 아님 단언
    - nullable type이지만 아무리 생각하더라도 Null이 아닌 경우
    - 예시로 DB에 맨 처음 데이터가 들어갈땐 null이었다가, 이후엔 어떤 경우에도 null이 아닌 경우
    - 매번 Safe-Call 해주기엔 번거롭다.
    - !!를 사용한다.
        - ?타입에 대해 !!.으로 메소드 호출
    - Null이 그래도 들어온다면 NPE 발생하므로 정말 심사숙고해서 사용

    플랫폼 타입
    - Kotlin에서 Java 코드를 가져다가 사용할 때
    - javax.annotation, android.support.annotation, org.jetbrains.annotation 패키지
    - @Nullable같은 어노테이션이 달려있으면 코틀린에서 참고하여 처리된다.
    - 만일 @Nullable이나 @NotNull이 없다면 코틀린이 null 가능 유무를 알 수 없다.
    - 코틀린에서 자바 코드를 사용할 때는 자바 코드의 null 유무를 꼼꼼히 살펴보아야 한다.
        - 아니면 코틀린으로 아예 래핑시키는 것도 좋다.
 */

fun main() {
    var person = Person("abc")
    startsWithA5(person.name)
}

fun startsWithA5(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?): Int {
    return str!!.length
}