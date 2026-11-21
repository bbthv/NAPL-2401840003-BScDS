import kotlin.math.abs

fun main() {
    print("Enter an integer: ")
    var n = abs(readln().trim().toInt())

    var sum = 0
    var count = 0

    if (n == 0) {
        count = 1          // the number 0 has one digit
    }

    while (n > 0) {
        sum += n % 10
        n /= 10
        count++
    }

    val average = sum.toDouble() / count
    println("Sum of digits : $sum")
    println("Digit count   : $count")
    println("Average       : $average")
}