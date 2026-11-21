// (1) Function with default parameters
fun greet(name: String, greeting: String = "Hello", punctuation: String = "!") {
    println("$greeting, $name$punctuation")
}

// (3) Function with vararg
fun printNumbers(vararg numbers: Int) {
    print("Received ${numbers.size} numbers: ")
    for (n in numbers) {
        print("$n ")
    }
    println()
}

// (4) Higher-order function taking a lambda (Int) -> Int
fun applyToList(list: List<Int>, operation: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in list) {
        result.add(operation(item))
    }
    return result
}

fun main() {
    println("--- (1) Default parameters ---")
    greet("Sneha")                          // both defaults used
    greet("Sneha", "Good morning")          // punctuation default used
    greet("Sneha", "Welcome", ".")          // no defaults used

    println("\n--- (2) Named arguments (out of order) ---")
    greet(punctuation = "?", name = "Rahul", greeting = "Hey")
    greet(greeting = "Namaste", name = "Anita")

    println("\n--- (3) Vararg ---")
    printNumbers(5, 10, 15)
    printNumbers(1, 2, 3, 4, 5, 6)
    printNumbers()                          // zero arguments is also valid

    println("\n--- (4) Higher-order function ---")
    val numbers = listOf(1, 2, 3, 4, 5)

    val squared = applyToList(numbers) { it * it }
    println("Squared : $squared")

    val doubled = applyToList(numbers) { x -> x * 2 }
    println("Doubled : $doubled")

    val addTen: (Int) -> Int = { it + 10 }
    println("Plus 10 : ${applyToList(numbers, addTen)}")
}