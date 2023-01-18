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
    // ver1. normal
    val st1 = startsWithA("abc")
    println(st1)

}

fun startsWithA(str: String): Boolean {
    // 일반적인 메소드
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
    // ?.(Safe Call) 연산자같은 경우 왼쪽이 null이라면 null 리턴
    // ?:(Elvis) 연산자같은 경우 왼쪽이 null이라면 우측 값 리턴, null이 아니라면 왼쪽 값(str?~) 리턴

    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null")
}

fun startsWithA2(str: String?): Boolean? {
    // ?.(Safe Call) 연산자로 인해 str이 null이라면 null이 리턴되며
    // null이 아니라면 startsWith 메소드를 호출합니다.

    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    // ?.(Safe Call) 연산자로 인해 str이 null이라면 null이 리턴되며, 아니라면 메소드를 호출합니다.
    // ?:(Elvis) 연산자로 인해 좌측의 함수 실행 결과가 null이라면 false가 리턴되며
    // , 아니라면 좌측의 함수 실행 결과가 리턴됩니다.

    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?): Int {
    // !!. : not-null assertion(널 아님 단언문)
    // str이 무조건 null이 아니라는 가정 하에 length 실행
    // null이라면 NPE 발생

    return str!!.length
}