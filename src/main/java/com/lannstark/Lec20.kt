package com.lannstark

/*
    scope function : 일시적인 영역을 형성하는 함수
    예시) safe call + let(scope function)의 한 종류로 null 체크를 깔끔하게 할 수 있습니다.

    let : 확장함수. 람다를 받아 람다 결과를 반환, 람다 안에서 it을 사용하여 접근할 수 있음
    람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나 method chaining에 활용하는 함수를 scope function이라고 합니다.

    확장함수 -> 멤버 함수처럼 사용할 수 있다는 특징

    it vs this
    - it은 생략이 불가능한 대신 ->를 써서 다른 이름을 붙여줄 수 있습니다.
    - this는 생략이 가능한 대신 다른 이름을 붙여줄 수 없습니다.
    - 코틀린의 문법 차이가 있습니다.
        - let은 일반 함수를 받기 때문에 파라미터를 내부에서 호출하기 때문에 이름을 직접 넣어줄 수 있습니다.
        - run은 확장 함수를 파라메터로 받기 때문에 확장함수는 본인 자신을 this로 호출하고 생략 가능합니다.
            - this.method()
            - fun Int.newSum(a: Int): Int = this + a

    1. let
        - 람다의 결과(람다식의 결과값) 리턴
        - it
        - 하나 이상의 함수를 call chain 결과로 호출할 때
        - non-null 값에 대해서만 code block을 실행시킬 때 가장 많이 사용
            - if (a == null) 이런 조건을 Safe-call과 함께 사용하여 깔끔하게 할 수 있음.
        - 일회성으로만 특정 변수를 만들 때
            - private function으로 빼서 depth를 줄이는게 더 좋을수도 있다.

    2. run
        - 람다의 결과(람다식의 결과값) 리턴
        - this
        - 객체 초기화와 반환 값의 계산을 동시에 해야할 때
            - val person = Person().run(personRepository::save)
            - personRepository.save(Person(..))이 더 명시적일 수도 있다. 잘 고민해보고 쓸 것
            - 생성자가 여러 줄이 생기는 경우 run을 사용하면 깔끔해질 수도 있음.

    3. also
        - 람다의 결과가 무관하게 객체 그 자체가 리턴
        - it
        - 객체 수정 로직이 call chain 중간에 필요한 경우
        - 잘 읽히는 정도를 바탕으로 고민해볼 것

    4. apply
        - 람다의 결과가 무관하게 객체 그 자체가 리턴
        - this
        - 객체 수정 로직이 call chain 중간에 필요한 경우
        - Test Fixture를 만들 때 추가로 필드를 수정해야 할 때
        - apply {}.let {}도 가능은 합니다만 잘 쓰진 않습니다.


    5. with -> 확장함수가 아닙니다.
        - with(파라미터, 람다) : this를 사용해 접근하며 this는 생략 가능합니다.
        - 람다 내부에서 this를 사용합니다.
        - this를 생략할 수 있기 때문에 필드가 많아도 코드가 간결해집니다.
        - 객체를 변환할 때 한쪽에 로직을 넣기 어려운 경우 사용

    scope function을 사용한 코드가 그렇지 않은 코드보다 가독성이 있을까?
    - takeIf, let, 메소드 레퍼런스 등을 모두 사용해서 개발한다면 숙련된 코틀린 개발자도 잘 이해하지 못할 수 있다.
    - 오히려 함수형보다 if문으로 풀어서 작성한 경우 디버깅이 더 쉬울 수 있으며, 수정도 더 쉬울 수 있습니다.
    - 사용 빈도가 적은 관용구는 코드를 더 복잡하게 만들고, 관용구들을 한 문장 내에서 조합해 사용하면 복잡성이 훨씬 증가할 수 있다.
    - scope function은 적절한 컨벤션을 적용하면 유연하게 사용할 수 있습니다.
        - 팀의 코틀린 숙련도
        - 개인이 어떤 코드를 선호하는지
        - 적절한 convention에서는 scope function을 사용하는 것도 좋다.
 */

fun withTest() {
    val person = Person("Kim", 10)

    with(person) {
        println(age)
        println(this.name)
    }
}


fun itVsThis() {
    val person = Person("hello", 123)

    person.let {
        it.age // it 생략 불가능. 하지만 a -> a.age같이 이름 변경은 가능
    }

    person.run {
        age // this 생략 가능, 단 ->로 이름 지정은 불가
    }
}

fun printPerson(person: Person?) {

    if (person != null) {
        println(person.name)
        println(person.age)
    }

    person?.let {
        println(it.name)
        println(it.age)
    }
}