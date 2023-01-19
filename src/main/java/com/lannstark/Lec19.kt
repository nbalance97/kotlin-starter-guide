package com.lannstark

/*

    1. Type Alias와 as import
        typealias
        - 긴 이름의 클래스나 함수 타입이 있을 때 축약하거나 더 좋은 이름을 사용하고 싶은 경우
        - (Apple) -> Boolean 타입은 너무 길다고 생각한다면..
        - typealias FruitFilter = (Apple) -> Boolean
        - typealias USGTMap = Map<String, UltraSuperGuardianTribe>

        다른 패키지의 같은 이름을 가진 함수를 동시에 가져오고 싶다면?
        - as import를 사용해야 합니다.
        - as import : 클래스나 함수를 임포트할 때 이름을 바꾸는 기능

        import com.xx.xx.a.printHelloWorld as printHelloWorldA
        import com.xx.xx.b.printHelloWorld as printHelloWorldB

    2. 구조분해
    - 복합적인 값을 분해하여 여러 변수를 한번에 초기화하는 것
    - Data Class는 자동으로 componentN이라는 함수도 만들어 둔다.
    - val (name, age) = person은 결국 name = person.component1(), age = person.component2()
    - component1은 첫번째 프로퍼티, component2는 두번째 프로퍼티를 가져오는 메소드. 결론적으로 구조분해는 componentN 메소드를 호출합니다.
    - 프로퍼티 순서대로 넣어주기 때문에 순서를 바꾸면 오동작한다.

    - Data Class가 아닌데 구조분해를 사용하고 싶다면?
        - operator fun componentN을 직접 명시하면 됩니다.
        - map.entries같은걸 (key, value)로 사용하는 것도 구조분해입니다.

    3. Jump와 Label
    - 코드의 흐름 제어 : return, break, continue
    - return은 가장 가까운 enclosing function 또는 익명함수로 값 반환
    - break는 가장 가까운 루프 제거
    - continue는 가장 가까운 루프를 다음 step으로
    - 코틀린은 자바와 완전히 동일합니다. 단!! forEach는 좀 다릅니다.
    - forEach문 내부의 람다에서는 continue나 break문은 결코 사용할 수 없습니다.

    - 꼭 사용하고 싶다면?
        - forEach를 block으로 감싸고 return@블록명 => break
        - forEach 내부에서 return@forEach => continue
        - break, continue는 최대한 익숙한 for문 사용하는것이 협업에 좋다.

        - 특정 expression에 라벨이름@을 붙여 하나의 라벨로 간주하고 break, continue, return 사용 가능

        loop@ for (i in 1..100) {
            for (j in 1..100) {
                break@loop // 맨 위쪽 반복문을 가리키므로 전체 반복문이 종료됩니다.
            }
        }


    - 라벨을 사용한 Jump는 사용하지 않는것을 강력 추천!! 코드의 흐름을 이해하기 정말 어려워진다.

    4. TakeIf와 TakeUnless
    - takeIf : 조건을 만족하면 해당 값이, 아니라면 null이 반환됩니다.
    - takeUnless : 조건을 만족하지 않으면 해당 값이, 아니라면 null이 반환
    - 나중에 코드를 줄이고 싶을 때 찾아보면 된다.


 */

fun getNumberOrNull2(number: Int): Int? {
    return number.takeIf { it > 0 }
}

fun getNumberOrNull(number: Int): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

fun forEachWithBreak() {
    val numbers = listOf(1, 2, 3)

    run {
        numbers.forEach {number ->
            if (number == 2) {
                return@run // run을 가리켜서 return하므로 break
            }
        }
    }

    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@forEach // foreach를 return하므로 continue
            }
        }
    }
}

fun forEachTest() {
    val numbers = listOf(1, 2, 3)

    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }
}

fun testPerson() {
    val person = Person("Lee", 15)
    val (name, age) = person

    println("이름 : ${name}")
    println("나이 : ${age}")

    val flatPerson = FlatPerson("Lee", 15)
    val (flatName, flatAge) = flatPerson

    println("이름 : ${flatName}")
    println("나이 : ${flatAge}")
}

class FlatPerson(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name

    }

    operator fun component2(): Int {
        return this.age
    }
}

data class Person(
    val name: String,
    val age: Int
)


typealias IntFilter = (Int) -> Boolean
typealias USGTMap = Map<String, UltraSuperGuardianTribe>

class UltraSuperGuardianTribe

fun main() {
    testPerson()
}