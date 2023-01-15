package com.lannstark.lec05

/*
    1. if문
        - 자바와 완전히 똑같습니다.
        - if, if-else, if-else if-else 모두 동일
        if (조건) {
            ...
        }

    2. Expression과 Statement
        if (조건) {
            ...
        } else {
            ...
        }

        - 자바에서의 if-else는 Statement(프로그램의 문장, 하나의 값으로 도출 불가능)
        - 코틀린에서의 if-else는 하나의 값으로 도출되는 문장(Expression)으로 취급됩니다.
        - 따라서 if-else문을 리턴할 수도 있습니다.
        - 코틀린은 if-else문을 expression으로 사용하므로 삼항 연산자가 존재하지 않습니다.

        팁)
        - 어떤 값이 특정 범위에 포함되어 있는지, 포함되어 있지 않은지
        - if (0 <= score && score <= 100)이랑 if (score in 0..100)은 같습니다.

    3. switch와 when
        when (값) {
            조건부 -> 어떠한 구문
            조건부 -> 어떠한 구문
            else -> 어떠한 구문
        }
        - 조건부에는 어떠한 Expression이라도 들어갈 수 있습니다(is도 가능)
        - 값이 없을 수도 있습니다.(when을 값 없이 early return처럼 사용)
        - when절 또한 Expression입니다.

        when절은 switch보다는 훨씬 유연하며 강력한 기능을 갖습니다.
        when은 Enum Class와 Sealed Class와 함께 사용할 경우 더욱더 진가를 발휘합니다.
 */

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A") // 스마트 캐스팅, 앞에서 is로 체크해 주었으므로 String 타입으로 간주
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("많이 본 숫자")
        else -> println("1, 0, -1이 아니군요.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("0이군요.")
        number % 2 == 0 -> println("짝수군요.")
        else -> println("홀수군요.")
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch3(score: Int): String {
    return when (score/10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int): String = when (score/10) {
    9 -> "A"
    8 -> "B"
    7 -> "C"
    else -> "D"
}

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}은 0보다 작을 수 없습니다.")
    }
}

fun validateScoreIsInRange(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}이 범위 밖입니다.")
    }
}

fun getPassOrFail(score: Int): String {
    return if (score > 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun main() {

}

