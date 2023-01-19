package com.lannstark.lec15

/*
    FP(함수형 프로그래밍)

    1. 배열
        - 배열은 프로덕션에서 잘 사용하지 않습니다.
        - array.indices 메서드를 사용하여 인덱스 범위를 가져올 수 있습니다.
        - array.withIndex 메서드를 사용하여 index-value 쌍을 가져올 수 있습니다.
        - array.plus 메서드를 사용하여 새로운 element 추가 가능, Java는 복사본을 만들어야 하는 것과 차이가 있다.

    2. 코틀린에서의 Collection - List, Set, Map
        - 컬렉션을 만들 때 가변인지 불변인지를 설정해 주어야 합니다.
        - Iterable - Collection - (List, Set, Map) - (MutableList, MutableSet, MutableMap)
        - 가변 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 있습니다.
        - 불변 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 없습니다.

        - Collections.unmodifiableList()라고 생각하면 됩니다.
        - 불변 컬렉션이라고 하더라도 Reference Type인 element의 field는 바꿀 수 있습니다.
        - 예시로 List<Money>에서 첫번째 요소(Money)에 접근하여 해당 요소의 내부에 있는 필드 값은 바꿀 수 있습니다.

        1. List
        - Java는 Arrays.asList 혹은 List.of
        - val list = listOf(100, 200)
        - val emptyList = emptyList<타입>() // 컴파일러가 추론할 수 없기 때문에 비어있는 리스트의 경우 타입이 무엇인지 명시적으로 적어주어야 합니다.
        - 단, 추론 가능하면 생략 가능합니다.
         에시로, 파라메터 타입이 List<Int>인 경우, emptyList()로 전달하여도 List<Int>로 추론 가능합니다.
        - 0번째 요소 접근 -> list[0]
        - 반복문은 in 연산자 혹은 (idx, value) 쌍으로 가져오려면 withIndex() 메소드를 사용합니다.


        - 가변 리스트를 사용하기 위해서는 MutableList를 사용합니다.
        - val numbers = mutableListOf(100, 200) // 기본적으로 ArrayList이며, 사용법은 자바와 똑같습니다.

        기본적으로 불변 리스트를 만들고, 필요한 경우 가변 리스트로 바꾸는 것이 좋습니다.

        2. Set
        - 순서가 없고, 같은 element는 하나만 존재할 수 있습니다.
        - 자료구조적인 의미를 제외하고 모두 리스트와 동일합니다.
        - 가변 집합을 만들고 싶다면 mutableSetOf 메소드를 사용합니다. - 기본적으로 LinkedHashSet을 사용합니다.

        3. Map
        - 자바는 Map을 만들고 값을 Put하는 방식 또는 Map.of 메소드로 키-값을 집어넣는 방식이 있습니다.
        - Kotlin도 동일하게 MutableMap과 정적 팩토리 메소드 활용이 가능하다.
        - 가변 Map의 경우 put 메서드를 사용하거나 또는 map[key] = value로 사용 가능합니다.
        - 값을 가져올 때도 get을 사용하거나 map[key]로 가져올 수 있습니다.
        - for문을 사용할 때는 keys로 키들을 가져와서 접근하거나, entries 프로퍼티를 사용하여 키-값 Pair을 모두 가져올 수 있습니다.

    3. 컬렉션의 null 가능성, Java와 어떻게 함께 사용할까?
        - List<Int?>, List<Int>?, List<Int?>?
        - List<Int?> : List에 null이 들어갈 수 있지만, 리스트는 절대 Null이 아님
        - List<Int>? : List에 null이 들어갈 수 없지만, 리스트는 null일 수 있음.
        - List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트 자체가 null일 수도 있음.
        - ? 위치에 따라서 null 가능성 의미가 달라지므로 차이 이해가 중요합니다.

        - 자바는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않습니다.
        - 코틀린에서 불변 컬렉션(listOf), 자바에서 코틀린의 컬렉션을 가져온 경우 Element를 추가해 버릴 수 있습니다.
        - 코틀린 입장에선 불변 리스트인데 자바에 의해 Element가 추가되는 오동작 발생 가능성이 있습니다.

        - 자바는 Nullable과 non-nullable 타입을 구분하지 않습니다.
        - 코틀린에서 null을 넣을 수 없다고 하더라도 자바는 null을 리스트에 추가할 수 있습니다.
        - 따라서, Kotlin 쪽에서 컬렉션이 Java에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 합니다.
        - 혹은, 코틀린 측에서 Collections.unmodifiable...를 사용하여 변경 자체를 막는 방법도 있습니다.(자바의 구현체)

        - Kotlin에서 Java 컬렉션을 가져다 사용할 때는 플랫폼 타입을 신경써야 합니다.
        - 자바가 List<Integer> 타입을 전달했다면, List<Int?>, List<Int>?, List<Int?>?중 어떤건지 자바 코드를 보며
          맥락을 확인하고 자바 코드를 가져오는 지점을 wraㅁpping 해주어야 합니다.
 */

fun mapTest2() {
    val oldMap = mapOf<Integer, String>()

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(oldMap[key])
    }
}

fun mapTest() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1, "MONDAY")
    oldMap[1] = "MONDAY" // 키 1에 MONDAY 삽입
    oldMap[2] = "TUESDAY"

    val secondaryMap = mapOf(1 to "MONDAY", 2 to "TUESDAY") // Pair 여러개를 두어서 처리

}

fun setTest() {
    val numbers = mutableSetOf(1, 2, 3)

    numbers.add(4)
}

fun mutableList() {
    val numbers = mutableListOf(100, 200) // 기본적으로 ArrayList이며, 사용법은 자바와 똑같습니다.

    numbers.add(10)
}

fun listGetTest() {
    val numbers = listOf(100, 200)

    println(numbers[0]) // 0번째 요소

    for (number in numbers) {
        println(number)
    }

    for ((idx, number) in numbers.withIndex()) {
        println("${idx} ${number}")
    }

}

fun listTest() {
    val list = listOf(100, 200)
    // val list = emptyList<>() // 타입 생략 불가능

    val numbers = listOf(100, 200)
    printNumbers(emptyList()) // emptyList()가 List<Int>임을 추론 가능하므로 생략 가능
}

fun printNumbers(list: List<Int>) {
    println(list)
}

fun arrTest() {
    val arr = arrayOf(1, 2, 3)

    for (data in arr) {
        println(data)
    }

    for (i in arr.indices) {
        println("${i} ${arr[i]}")
    }

    for ((idx, value) in arr.withIndex()) {
        println("${idx} ${value}")
    }

    arr.plus(1) // 배열에 요소 추가
}

class Lec15MainKt {
}