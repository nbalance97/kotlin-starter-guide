package com.lannstark.lec03

/*
    Kotlin의 Any는 Java의 Object

    1. 기본 타입
    - Int, Long, Float, Double 이외에도 Byte, Short 등등
    - 선언된 기본값을 보고 타입을 추론합니다.
        - 3 -> Int
        - 3L -> Long
        - 3.0f -> Float
        - 3.0 -> Double
    - 자바는 기본 타입간의 변환은 암시적, 코틀린은 기본 타입간의 변환은 명시적
        int number1 = 4;
        long number2 = number1;
        number1 + number2 // 암시적으로 자바가 처리
        // 코틀린에서는 에러가 발생
    - 코틀린에서는 to변환타입()를 무조건 써주어야 함.
        val number1 = 3
        val number2: Long = number1.toLong()
    - 코틀린의 타입 변환은 .to변환타입() 메서드 사용
    - null이 들어갈 수 있는 경우(Int?, ...) 적절한 처리(Safe-call, Elvis) 필요
    
    2. 타입 캐스팅
    - 일반 타입에 대한 타입 캐스팅은 어떻게 해야 할까요?
    - 자바는 instanceof + (타입)인스턴스 사용
    - 코틀린에서는..
        1. Object 대신 Any
        2. instanceof 대신 is
            - value is Type
        3. 괄호로 캐스팅하는 것이 아닌 "as 타입"으로 캐스팅, 
            - as는 앞에서 is로 검사했다면 스마트 캐스팅으로 인해 생략 가능
        4. 타입이 아닌지 검사할 때는 !is
            - value !is Type
    - null이 가능하다면 as?로 캐스팅하고 사용시에도 ?. 연산자로 사용
        - as?는 value가 Type이라면 Type로 타입 캐스팅
        - as?는
            1.타입이 아닌 경우
            2.null인 경우
            모두 null을 리턴합니다.
    
    3. 코틀린의 3가지 특이 타입
        1. Any
            - Java의 Object 역할
            - 모든 Primitive Type의 최상위 타입도 Any
            - null을 포함하고 싶다면 Any?로 표현
            - Any에 equals, hashCode, toString 존재
        2. Unit
            - Java의 void와 동일한 역할
            - void와 다르게 Unit은 자체로 타입 인자로 사용 가능(Void와 비슷)
            - 함수형 프로그래밍에서의 Unit은 단 하나의 인스턴스만 갖는 타입, Unit은 실제 존재하는 타입이라는 것을 표현
        3. Nothing
            - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
            - 무조건 예외를 반환하는 함수 / 무한 루프 함수 등

    4. String Interpolation, String Indexing
        1. 문자열 가공
            - String.format 메서드를 사용하지 않고 ${변수}를 사용하여 문자열 내부에 변수 삽입 가능
            - 중괄호를 생략 가능(person.name이 아닌 그냥 name인 경우)
                - 중괄호를 사용하는 것이 가독성, 일괄 변환, 정규식 활용 측면에서 좋음.
            - """ 문자열 """ .trimIndent()
        2. 문자열 인덱싱
            - 문자열에서 특정 문자열 가져오기
                - 자바에서는 charAt(Index)를 사용합니다.
                - 코틀린에서는 str[index]로 특정 위치의 문자를 가져올 수 있습니다.

    instanceof의 걍우, Kotlin에서는 is를 사용합니다.
 */
fun main() {

    val person = Person("abcde", 15)

    printAgeIfPersonNullable(null)
    printAgeIfPersonV1(person)
    printAgeIfPersonV2(person)
}

fun printAgeIfPersonV1(obj: Any) {
    
    if (obj is Person) {
        var person = obj as Person
        println(obj.age)
    }
}

fun printAgeIfPersonV2(obj: Any) = when(obj) {
    is Person -> println(obj.age)
    else -> {}
}

fun printAgeIfPersonNullable(obj: Any?) {
    val person = obj as? Person // obj가 null이 될수 있는 경우 as?

    // as?를 사용해 준다면 obj가 null인 경우 person도 null이 된다.
    // as?가 아닌 as로 하면 as에서 NPE가 발생한다. 아래 코드는 실행되지 않음.

    person?.age // null인 경우 person도 null이 되므로 safe-call 필요
}

