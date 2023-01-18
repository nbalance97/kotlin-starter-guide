package com.lannstark.lec13

/*
 중첩 클래스의 종류
    - 자바의 중첩 클래스의 종류
    - static을 사용하는 중첩 클래스 / static을 사용하지 않는 중첩 클래스
    - static을 사용하지 않는 중첩 클래스에는 내부 클래스, 지역 클래스, 익명 클래스가 있습니다.
    - static을 사용하는 중첩 클래스의 경우 밖의 클래스를 직접 참조할 수 없습니다.
    - 내부 클래스는 밖의 클래스를 직접 참조 가능합니다.
    - 지역 클래스는 메소드 내부에 클래스를 정의합니다.
    - 익명 클래스는 지난 시간에 다루었던 일회성 클래스입니다.
    - 중첩 클래스라고 하면 주로 클래스 안에 클래스가 중첩된 내부 클래스, static을 사용하는 중첩 클래스를 지칭합니다.
    - 결론적으로 말하자면 static을 사용하는 중첩 클래스를 권장합니다. => 바깥 클래스에 대한 참조가 없기 때문입니다.

    내부 클래스
    - 바깥 클래스를 사용 가능합니다.
    public class JavaHouse {
      ...
      public class LivingRoom {
        private double area;

        public LivingRoom(double area) {
          this.area = area;
        }

        public String getAddress() {
          return JavaHouse.this.address; // 바깥 클래스 사용 가능, 바깥 클래스에 대한 직접적인 참조를 가지고 있습니다.
        }
      }
    }

    static을 사용하는 중첩 클래스
    - 바깥 클래스를 사용 불가능합니다.
    public class JavaHouse {
      ...
      public static class LivingRoom {
        private double area;

        public LivingRoom(double area) {
          this.area = area;
        }

        public String getAddress() {
          return JavaHouse.this.address; // 바깥 클래스 사용 불가능. 직접적인 참조가 존재하지 않는다.
        }
      }
    }

    단점
    - 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우 메모리 누수 + 디버깅 어려움이 있습니다.
    - 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있습니다.
    - 내부 클래스가 외부 클래스를 참조함으로써 생기는 몇가지 문제점(이펙티브 자바)
        => 클래스 안에 클래스를 만들때는 Static 클래스를 사용하라.

 코틀린의 내부 클래스
    1. 자바의 static 중첩 클래스(권장되는 형태)
    - 그냥 내부에 똑같이 class를 만들어 주면 됩니다. 기본적으로 코틀린은 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어 집니다.
    2. 권장되지 않는 방식
    - 내부 클래스에 inner 키워드를 추가합니다.
    - 바깥 클래스의 값을 가져오려면 this@바깥 클래스명.필드명 이런식으로 가져오면 됩니다.

    - 기본적으로 바깥 클래스를 참조하지 않습니다.
    - 굳이 참조하려면 inner 키워드 + 외부 접근시 this@클래스명

 */

class JavaHouse2 (
    private val address: String,
    private val livingRoom: LivingRoom
) {
    inner class LivingRoom(
        private var area: Double
    ) {
        val address: String
            get() = this@JavaHouse2.address
    }
}

class JavaHouse1 (
    private val address: String,
    private val livingRoom: LivingRoom
) {
    class LivingRoom( // 권장되는 형태
        private val area: Double
    )
}

class Lec13MainKt {
}