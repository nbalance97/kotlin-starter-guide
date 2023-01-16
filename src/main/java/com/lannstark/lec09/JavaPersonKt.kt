package com.lannstark.lec09

/*
    기본으로 class는 public
    코틀린에서는 필드만 만들어 주더라도 getter, setter은 자동으로 만들어 줍니다.
        => 따라서 프로퍼티라고 부릅니다.
    constructor라는 지시어는 생략 가능합니다.(class b constructor(...) {}

    코틀린에서는 생성자에서 프로퍼티로 만들어 줄 수 있습니다.
    class person(val name: String, var age: Int) ...

    코틀린에서는 .필드 를 통해 getter과 setter을 사용할 수 있습니다.

    자바 코드에서는 생성자에서 검증이 가능한데, 코틀린은 어디에서 검증을 해줄 수 있을까요?
    코틀린에서는 init 블록이 존재합니다. init 블록이란 초기화하는 시점(생성자가 호출되는 시점)에 한번만 실행되는 부분입니다.

    생성자를 여러개 만들려고 하려면 어떻게 할 수 있을까요?
    - constructor로 새로운 생성자를 만든 다음, this(name, 1)같이 주생성자를 호출합니다.
    - 맨 위에서 지정한 부분을 주생성자라고 합니다. person(val name: String, var age: Int)... 이 부분.
    - 아래에 정의한 constructor를 부생성자라고 하며 있을수도 있고 없을수도 있습니다.
        - 최종적으로 주 생성자를 this를 호출해야 합니다.
        - body를 가질 수 있습니다.

    constructor(name: String): this(name,  1), ...
    - 부 생성자를 호출하는 경우 주 생성자부터 실행됩니다.

    코틀린에서는 추가적인 부생성자를 만드는것 보다는 default parameter를 사용하는 것을 권장합니다.
    - Converting같은 경우 부생성자를 사용할 수 있지만, 그보다는 정적 팩토리 메서드를 추천

    fun isAdult => 함수인것처럼 접근
    val isAdult => 프로퍼티처럼 접근
    객체의 속성이라면 custom getter, 그렇지 않다면 함수

    isAdult는 사람이 성인인지 아닌지에 대한 속성을 확인, custom getter가 더 좋을수도 있다.

    custom getter의 경우는 자기 자신을 변환시켜줄 수도 있습니다.
    - 자기를 가리킬 때는 field라는 키워드를 사용합니다.
    - field는 무한루프를 막기 위해 사용됩니다.
    - name.uppercase()라고 하게 되면, name에 대한 get()이 호출되게 되어 무한루프가 발생합니다.

    backing field
    - 자기 자신을 가리키는 보이지 않는 field라고 하여 backing field라고 부릅니다.
    - 강사님의 의견으로는 backing field를 쓰는 경우는 드뭅니다.
    - this.name.uppercase()로

    실제 메모리에 존재하는 것과 무관하게 custom getter, custom setter를 만들 수 있습니다. -> 실제 바이트코드를 까보면 함수
    무한루프를 막기 위해 field라는 키워드 사용 -> backing field
 */

class JavaPersonKt (
    name: String,
    var age: Int, ) {

    var name = name
        set(value) { // 사실상 setter 자체를 지양하기 때문에 custom setter도 잘 안씁니다,,
            field = value.uppercase()
        }

    val uppercaseName: String
        get() = this.name.uppercase()


    init { // 초기화하는 시점에 한번만 실행되는 부분
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    constructor(name: String): this(name,  1) // 주생성자 호출

    constructor(): this("a") { // 위의 부생성자 호출하지만, 최종적으로 주생성자를 호출하므로 괜찮다.
        print("abc") // block 내에 코드 작성 가능
    }

    /* function과 custom getter */

    fun isAdult1(): Boolean { // 함수처럼 만드는 방법
        return this.age >= 20
    }

    val isAdult2: Boolean // 프로퍼티처럼 보이게 하는 방법, =도 되며 {}도 가능하다.
        get() = this.age >= 20

}

fun main() {
    val person = JavaPersonKt("Kim", 100)

    person.name // getter을 호출한다.
    person.age = 10 // setter을 호출한다.

    val javaPerson = JavaPerson("Kim", 100)
    javaPerson.age = 10 // java의 클래스를 사용하는 경우에도 getter를 호출한다.



}