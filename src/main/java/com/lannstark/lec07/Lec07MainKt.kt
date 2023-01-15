package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.NumberFormatException

/*
    기본 타입간의 형변환은 toXXX() 사용
    1. try catch finally 구문
        - try-catch-finally 역시 자바와 코틀린이 거의 같다.
        - 단, 코틀린에서는 try 또한 expression이므로 리턴이 가능하다

    2. Checked Exception vs UnChecked Exception
        - 자바의 Checked Exception은 throws를 명시해주거나 try-catch-finally로 무조건 묶어주어야 한다.
        - 코틀린에서는 throws 구문이 존재하지 않는다.
        - 코틀린은 Checked Exception, UnChecked Exception 구분하지 않고 모두 Unchecked Exception
        - 코딩할때 편하다는 장점이 있다.

    3. try with resources
        - 코틀린에는 Try-with-resources가 존재하지 않는다.
        - use 메서드를 사용한다. Closeable의 확장 함수로, use 메서드 내부에서 close() 메소드를 호출시켜 준다.
 */

fun readFile() {
    val currentFile = File("")
    val file = File(currentFile.absolutePath + "/a.txt")

    val reader = BufferedReader(FileReader(file))
    val line = reader.readLine()

    print(line)

    reader.close()


}

fun readFile(path: String) {
    // 코틀린에는 try-with-resource 구문이 없습니다.
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}

fun parseIntOrThrow(str: String): Int {

    /*
    타입이 뒤에 존재하며, 포맷팅이 간결함
    new를 사용하지 않음
    */

    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}은 문자열이 아닙니다.")
    }
}

fun parseIntOrThrow(str: String?): Int? {
    return try {
        str?.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun main() {
    readFile()
}