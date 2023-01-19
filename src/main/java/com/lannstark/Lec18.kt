package com.lannstark

/*
    1. 필터와 맵
        1. 필터
        - list.filter 메서드를 사용하면 원하는 요소만 걸러줄 수 있습니다.
        - 필터에서 인덱스가 필요한 경우 filterIndexed를 사용합니다.

        2. 맵
        - 사과의 요소중 필요한 요소들만 꺼낼 수 있습니다.
        - 인덱스가 필요한 경우 mapIndexed
        - 결과가 null이 아닌 것만 가져오고 싶은 경우 mapNotNull


    2. 다양한 기능
        - all : 조건을 모두 만족하면 true, 아니라면 false
        - none : 조건을 모두 불만족하면 true, 아니라면 false
        - any : 조건을 하나라도 만족하면 true, 그렇지 않으면 false
        - 전체 사고 개수? 낮은 가격 순으로? 과일 종류가 몇개인지?

        1. count
        - 개수를 셉니다.(리스트의 size)

        2. sortedBy
        - 기본적으로 오름차순 정렬을 합니다.
        - 내림차순 정렬은 sortedByDecending

        3. distinctBy
        - 변형된 값을 기준으로 중복을 제거합니다.
        - distinctBy { fruit -> fruit.name } => 이름 단위로 중복 제거

        4. first, firstOrNull
        - first는 첫번째 값을 가져온다. 무조건 null이 아니어야 하며 null이라면 예외 발생
        - firstOrNull은 첫번째 값 또는 null을 가져옵니다.

        5. last, lastOrNull
        - last는 마지막 값을 가져오며 무조건 null이 아니어야 합니다.
        - lastOrNull은 마지막 값 또는 null을 가져옵니다.

    3. List를 Map으로
        - groupBy, associateBy

        1. 과일이름 -> List<과일> Map이 필요한 경우
        - apples.groupBy { apple -> apple.name }
        - key에 name, value에 name에 해당하는 List<Apple>

        2. id -> 과일
        - apples.associateBy { apple -> apple.id }
        - id를 통해서 무언가를 매핑(중복되지 않은 키로 map을 만드는 경우)
        - 위와 다른점은 List와 단일 인스턴스의 차이

        3. 과일명 -> List<출고가> Map
        - apples.groupBy({ apple -> apple.name }, { apple -> apple.price })
        - 첫번째 인자가 키, 두번째 인자가 값

        4. id -> 출고가 Map
        - apples.associateBy({ apple -> apple.id }, { apple -> apple.price })
        - 함수형 인터페이스를 여러개 받는 경우 중괄호를 괄호 밖으로 빼는것이 아니라 괄호 안에 써주는게 컨벤션

        5. Map은 filter나 map같은 함수를 사용할 수 있다.


    4. 중첩된 컬렉션 처리
    - flatMap 사용, List<List<>>를 단일 List로 변환 가능
    - List<List<Apple>>를 그냥 List<Apple>로 바꾸기 위해서는 flatten() 메서드 사용




 */

fun main() {

}

fun filterFruits2(
    apples: List<Apple>, filter: (Apple) -> Boolean
): List<Apple> {

    return apples.filter(filter)
}

fun filterFruits(
    apples: List<Apple>, filter: (Apple) -> Boolean
): List<Apple> {

    val result = mutableListOf<Apple>()
    for (apple: Apple in apples) {
        if (filter(apple)) {
            result.add(apple)
        }
    }

    return result
}

data class Apple(
    val name: String,
    val price: Int
)