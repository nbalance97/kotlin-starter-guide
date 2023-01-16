package com.lannstark.lec08

/*
    1. 함수 선언 문법
        - 접근지시어 public은 생략 가능합니다.
        - fun은 함수를 의미하는 키워드
        - 이수 함수 이름(지시어)
        - 매개변수는 매개변수명:타입, 이후 :리턴타입
        - if-else는 Expression이기 때문에 바로 리턴 가능하며, 함수가 하나의 결괏값이라면 블록 대신에 = 사용 가능
        - =를 사용하는 경우에는 리턴 타입 생략 가능

    2. default parameter
        - 기존에는 자바의 오버로딩을 사용하여 편의성을 추가하기 위해 여러 경우에 대하여 모두 오버로딩
            - 반복하는 횟수를 3회를 많이 사용해서 num이 3인 경우에 대한 편의 메서드
            - useNewLine을 true로 자주 사용해서 true로 고정시킨 편의 메서드
        - 모든 케이스에 대해서 편의를 위해 메소드를 만들어야 할까?
            repeat(str, num, useNewLine), repeat(str, num), repeat(str), ...??
        - 해결하기 위해 default parameter 사용
        - 밖에서 파라미터를 넣어주지 않는다면, 기본값을 사용합니다. (밖에서 넣어주면 넣어준 값을 사용합니다!!)
        - 코틀린도 물론 오버로딩를 할 수도 있습니다.

    3. named argument
        - 매개변수 이름을 통해 직접 지정 가능합니다.
        - 지정해주지 않은 매개변수는 기본 값을 사용합니다.
        - builder를 직접 만들지 않더라도 builder의 장점을 갖게 됩니다.
        - 단, 코틀린에서 자바 함수를 가져다가 쓸 때는 named argument 사용이 불가능합니다.
            - 코틀린에서 자바 코드를 쓸 때, 자바가 바이트 코드로 변환될 때 파라메터 이름이 보존되지 않기 때문입니다.

    4. 가변인자
        - 자바에서는 타입...를 사용하여 가변인자 사용, 호출한 쪽에서 배열이나 ,를 통해 여러 파라메터를 넣을 수 있었습니다.
        - vararg strings: String
        - ,를 통해 여러 파라메터를 넣을 수 있습니다.
        - 배열을 넣어서 호출하는 경우 *(spread) 연산자를 붙여서 넣어주어야 합니다.
 */

fun printAll(vararg strings: String) { // 가변 인자 선언
    for (str in strings) {
        println(str)
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}


fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) { // 3과 true는 따로 입력받지 않은 경우의 기본값(default parameter)
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun max2(a: Int, b: Int): Int { // if문을 바로 리턴
    return if (a > b) {
        a
    } else {
        b
    }
}

fun max(a: Int, b: Int): Int = // 블록 대신에 = 사용
    if (a > b) {
        a
    } else {
        b
    }

fun max3(a: Int, b: Int) = if (a > b) a else b // = 사용하는 경우에는 리턴 타입 생략 가능, 한줄이면 중괄호도 생략





fun main() {
    repeat("hello world", 3, false)
    repeat("hello world", useNewLine = false)

    printNameAndGender("female", "kim") // 매개변수에 맞지 않은 문자열이 들어간다.
    printNameAndGender(name="kim", gender="female") // 명시적으로 어느 매개변수에 어느 값이 들어가는지 알 수 있습니다. builder의 장점을 누린다.

    printAll("A", "B", "C")
    printAll(*arrayOf("A", "B", "C")) // spread 연산자로 배열 안에 있는 요소들을 ,를 쓰는 것처럼 꺼내줍니다.
}