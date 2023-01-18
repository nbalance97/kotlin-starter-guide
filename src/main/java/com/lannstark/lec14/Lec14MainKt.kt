package com.lannstark.lec14

/*
    1. Data Class
        - 계층간의 데이터를 전달하기 위한 DTO에서 사용
        - 데이터(필드), 생성자와 getter, equals, hashCode, toString 등의 메소드들을 가지고 있습니다.
        - Java에서는 IDE 또는 Lombok을 사용합니다.
        - 코틀린에서는 data class로 클래스를 정의합니다.
            - equals, hashCode, toString 메소드를 자동으로 만들어 줍니다.

        - 여기에 named argument까지 사용하면 빌더 패턴을 사용하는것과 같은 효과를 갖습니다.
        - Java에서는 jdk 16부터 record 제공

    2. Enum Class
        - 문법 자체는 자바와 크게 다를게 없다.
        - when절과 함께 사용하면 좋다고 했었는데..
        - 자바에서는 if - else를 여러번 사용해서 Enum을 처리, 코드 양이 많아서 가독성이 떨어지며 else 로직을 처리해야 합니다.
        - when절을 사용하여 enum 분기처리를 한다면 enum에 값이 추가된다고 하더라도 컴파일러 단에서 에러 또는 경고를 감지합니다.

    3. sealed class, sealed interface
        - 상속이 가능하도록 추상클래스를 만들고 싶은데, 외부에서는 이 클래스를 상속받지 않는 경우
        - 작성한 클래스만 하위 클래스가 되도록 하기 위해, 런타임 시점에 클래스 타입이 추가될 수 없습니다.
        - 하위 클래스는 같은 패키지에 있어야 합니다.

        vs Enum
        - 클래스를 상속받을 수 있습니다.
        - 하위 클래스는 멀티 인스턴스가 가능합니다. enum은 싱글톤

        when과 함께 사용하면 좋다.
        - is와 하위 구현체를 사용하여 분기 처리하기 좋습니다.
        - 추상화가 필요한 Entity나 Dto에는 Sealed class를 활용


 */

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> {}
        Country.AMERICA -> {}
        // else는 따로 필요 없다. country가 이미 두개가 있는지 알고 있음
    }
}

class Lec14MainKt {
}