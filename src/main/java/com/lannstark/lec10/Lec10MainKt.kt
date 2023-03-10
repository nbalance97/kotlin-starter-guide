package com.lannstark.lec10

/*
    1. 추상클래스
        - extends가 아닌 :(콜론) 사용, 좌우로 한칸씩 띄워야 합니다(컨벤션)
        - 상속받을 때, 상위 클래스의 생성자를 바로 호출해야 합니다.
            class Cat(프로퍼티 or 파라메터) : Animal(..) -> 상위 클래스의 생성자
        - 오버라이딩 하는 경우 override 키워드를 함수 앞에 필수로 붙여주어야 합니다.
        - 추상 프로퍼티가 아니라면 상속받을 때 반드시 open을 정의해 주어야 합니다.
            - 추상 클래스에서 자동으로 만들어진 getter를 오버라이드 할 수 있습니다.
            - 상위 클래스에 접근하는 키워드는 super입니다.

        - 자바, 코틀린 모두 추상 클래스는 인스턴스화 할 수 없습니다.
    2. 인터페이스
        - 인터페이스 구현도 :를 사용합니다.
        - 중복되는 인터페이스를 특정할땐 super<타입>.함수
        - 자바와 코틀린 모두 인터페이스를 인스턴스화 할 수 없습니다.
        - backing field가 없는 프로퍼티를 Interface에 만들 수 있습니다.
            - 인터페이스에 val로 프로퍼티를 선언해 두면
            - 하위에서 getter를 오버라이드 해서 사용하는 것으로 이해
    3. 상속 시 주의할 점
        - 자식 클래스를 인스턴스화 하는 경우
        - 부모 클래스의 init 블록이 먼저 호출되고, 자식 클래스의 init 블록이 실행된다.
        - 상위 클래스의 init 블록이 실행되는 동안, 하위 클래스의 값을 가져온다면 초기화되지 않는 값을 가져올 수도 있다.
        - 따라서 상위 클래스의 constructor, init 블록에서는 하위 클래스의 필드에 접근하면 안됩니다.
        - 따라서, 생성자 또는 초기화 블록에 사용하는 프로퍼티는 open을 무조건 피해야 한다.
    4. 상속 키워드
        1. final -> override를 할 수 없게 한다. 기본으로 Default, 보이지 않게 존재한다.
        2. open : override를 열어 준다.
        3. abstract : 반드시 override 해야 한다.
        4. override : 상위 타입을 오버라이드 하고 있다.

     - 상속 또는 구현을 할 때에 :를 사용
     - 상위 클래스 상속을 구현할 때 생성자를 반드시 호출
     - override 필수로 붙여야 합니다.
     - 추상 멤버가 아니면 기본적으로 오버라이드가 불가능 하므로 open 키워드를 붙여주어야 합니다.
     - 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용한다면 예기치 못한 버그가 생길 수 있습니다.
 */

fun main() {

}