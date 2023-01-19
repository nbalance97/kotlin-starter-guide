package com.lannstark.lec04


/*
    단항 연산자, 산술 연산자, 비교 연산자 모두 동일합니다.
    단, 비교 연산자(<, >, =)를 사용하는 경우 코틀린에서는 자동으로 compareTo 메서드를 호출합니다.
    - compareTo는 작으면 음수, 같으면 0, 크면 양수를 반환
    - 객체 비교시에도 비교연산자를 사용할 수 있습니다. (compareTo 호출)
    - 코틀린에서 compareTo 정의시 operator fun compareTo(other: ..) 으로 정의

    동등성 : 두 객체의 값이 같은가?
    동일성 : 완전히 동일한 객체인가? 주소가 같은가?

    자바에서는 동일성을 ==으로 확인, 동등성을 equals() 사용
    코틀린에서는 동일성에 ===를 사용, 동등성을 == 사용
        - == 사용 시 equals() 메소드를 호출시켜 준다.
        - 구현 시 equals()에 대하여 오버라이딩합니다.

    논리 연산자(&&, ||, !)는 Java와 완전히 같으며 Lazy 연산을 수행합니다.
        - Lazy 연산 : f1() || f2()의 경우 f1()가 True라면 f2()는 호출되지 않습니다.
        - 앞에 것이 True면 뒤에것을 볼 필요도 없습니다.
        - f1() && f2()일 떄는 f1()이 False라면 뒤에건 수행하지 않습니다.

    in / !in
    - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
    - 1 <= a <= 6은 a in 1..6과 같습니다.

    a..b
    - a부터 b까지의 범위 객체를 생성한다.

    a[i]
    - a에서 특정 Index i로 값을 가져온다

    a[i] = b
    - 특정 index i에 값을 넣는 케이스

    연산자 오버로딩
    - 코틀린은 객체마다 연산자를 직접 정의할 수 있습니다.
    - plus() 메소드 -> + 연산자를 사용할 때 메서드 호출
    - compareTo() 메소드 -> 비교 연산자 사용 시 메서드 호출
    - operator 키워드를 앞에 붙여서 선언해 줍니다.
        - ex) operator fun plus(other: 클래스명) = this.value + other.value
    - https://kotlinlang.org/docs/operator-overloading.html
 */

fun main() {
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {  // 자동으로 compareTo를 호출하게 됩니다.
        println("Money1이 금액이 더 큽니다.")
    }

    val money3 = JavaMoney(1_000L)
    println(money3 == money2) // money3.equals(money2)
    println(money3 === money2) // money3 == money2 (Java)

    val moneySum = JavaMoney(1_000L) + JavaMoney(2_000L)
    // plus() 메서드가 호출됩니다.
    println(moneySum)

    val ktMoney = Money(2000)
    val ktMoney2 = Money(3000)

    println(ktMoney < ktMoney2) // compareTo

    println(checkIn(101))
    println(checkIn(99))
}

fun checkIn(v: Int) = v in 1..99

class Money(
    val value: Int
) {
    operator fun compareTo(money: Money) = value.compareTo(money.value) // < > = 연산시 사용됩니다.
}