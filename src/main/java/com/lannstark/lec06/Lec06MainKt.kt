package com.lannstark.lec06

/*
    코틀린의 반복문은 자바와 유사합니다.

    1. for-each
        - 자바에서는 :을 쓰지만 kotlin에선 in
        - iterable이 구현된 타입이라면 모두 사용 가능

    2. 전통적인 for문
        - for (i in 1..3) // 1..3은 범위를 나타냅니다.(1부터 3까지)
        - for (i in 3 downTo 1) // 3,2,1 downTo가 Iterable이 구현되어 있음.
        - for (i in 1..3 step 2) // 1부터 3까지 2씩 증가시킨다.

    3. Progression과 Range
        동작 원리
        - in, step, downTo 등은 결국 Range(범위), Progression(등차수열)을 사용합니다.
        - .. 연산자는 범위를 만들어 내는 연산자, 1..3은 1부터 3까지의 범위
        - Range라는 클래스는 Progression을 상속받고 있다.
        - ..연산자는 Range를 반환하며, 1에서 시작하고 3으로 끝나는 등차수열을 만들어 달라는 의미. (Step은 생략시 1)
        - 3 downTo 1 : 시작값 3, 끝값 1, 공차 -1
        - downTo와 step 또한 함수입니다. (중위함수로 함수 호출을 다르게 해준 것 뿐)
        - 변수 함수이름 Argument로 사용 가능하도록 하기 위해서 중위함수 사용
        - (1..5) -> 1~5까지 공차가 1인 등차수열
        - (1..5) step 2 -> 위 등차수열에 step 함수 호출(파라미터로 2) = 등차수열.step(2)

    4. while문
        - 자바와 똑같습니다.
        - val 대신에 var을 사용하면 됩니다.
 */

fun main() {
    val numbers = listOf(1, 2, 3)
    for (number in numbers) {
        println(number)
    }

    for (i in 1..5 step 2) {
        println(i)
    }

    var i = 1
    while (i <= 3) {
        println(i)
        i++;
    }
}