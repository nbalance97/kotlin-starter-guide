package com.lannstark.lec17

/*
    1. Java에서 람다를 다루기 위한 노력
        - 중복을 제거하기 위한 익명 클래스 활용 -> 익명 클래스는 많이 복잡합니다.
        - JDK8부터는 람다(이름없는 함수)가 등장
        - Predicate, Consumer 등의 인터페이스를 많이 만들어 두었습니다.
        - 람다 : (변수) -> {}

        - for을 간결하게 처리하기 위해 stream이 등장
        - 람다는 메소드 레퍼런스(::)를 사용하여 더 간결해짐
        - 메소드 자체를 직접 넘겨주는 것처럼 쓸 수 있다. 실제로 넘겨주는건 Predicate
        - 함수를 자바에서는 2급 시민으로 간주하고, 변수에 직접 할당 또는 파라메터로 전달할 수 없습니다.

    2. 코틀린에서의 람다
        - 자바와 근본적으로 다른 한가지
        - 코틀린에서는 함수가 그 자체로 값이 될 수 있습니다.
        - 변수에 할당될수도, 파라미터로 넘길 수도 있습니다.

        1. 일반적인 방식으로 만드는 경우
        val add = fun(a: Int, b: Int): Int {
            return a + b
        }

        2. 중괄호와 화살표를 사용한 방법
        val add2 = {a: Int, b: Int -> a + b}

        3. 파라메터가 한개인 경우 It 키워드 사용 가능
        val identitial: (Int) -> Int = { it }

        호출 방법
        add(1, 2) // 람다 호출
        add.invoke(1, 2) // 람다 호출 2

        람다의 타입
        (파라메터 타입, ..) -> 리턴 타입
        val add: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
            return a + b
        }

        - 코틀린에서는 함수 자체가 1급 시민입니다.
        - 마지막 파라메터가 함수인 경우, 소괄호 바깥에 람다 식을 써줄 수 있습니다.
            printResult(1, 2) { // 마지막 파라메터가 람다인 경우 중괄호로 따로 빼기 가능
                a: Int, b: Int -> a + b
            }

        - 람다를 작성할 때, 람다의 파라미터를 it으로 직접 참조 가능
        - 람다 블록의 마지막 Expression이 리턴 값이다. 굳이 return 키워드를 사용하지 않아도 된다.

    3. Closure
        - 자바에서는 람다를 사용할 때 사용할 수 있는 변수에 제약이 있습니다.
        - final이거나 실질적으로 final인 변수만 사용 가능
        - 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수를 모두 포획해서 그 정보를 가지고 있어 크게 제약이 없습니다.
        - 이렇게 해야만 람다를 진정한 일급 시민으로 간주할 수 있습니다. 포획한 모든 정보를 가지고 있는 데이터 구조를 Closure라고 부른다.

    4. try-with-resources
        - use 메소드를 확인해 봅시다.
        - use는 Closeable 구현체에 대한 확장함수입니다.
        - inline 함수이며, (T) -> R 타입의 매개변수를 받습니다.

        T.use {
            ...
        }

 */


fun main() {
    val add: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
        return a + b
    }
    
    val identitial: (Int) -> Int = { it }

    val add2 = {a: Int, b: Int -> a + b}

    add(1, 2) // 람다 호출
    add.invoke(1, 2) // 람다 호출 2

    printResult(1, 2, add)
    printResult(1, 2) { // 마지막 파라메터가 람다인 경우 중괄호로 따로 빼기 가능
        a: Int, b: Int -> a + b
    }
}

fun printResult(a: Int, b: Int, f: (Int, Int) -> Int) {
    print(f(a, b))
}