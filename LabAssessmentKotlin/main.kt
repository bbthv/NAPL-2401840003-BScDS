
data class Course(
    val name: String,
    val fee: Int,
    val seats: Int?
)

fun main() {

    val courses = listOf(
        Course("Kotlin", 5000, 10),
        Course("Python", 4000, 0),
        Course("Java", 4500, null)
    )

    println("All Courses:")
    courses.forEach {
        println("${it.name} - ${it.fee}")
    }

    val names = courses.map { it.name }
    println("\nCourse Names: $names")

    val affordable = courses.filter { it.fee <= 4500 }
    println("\nAffordable Courses:")
    affordable.forEach {
        println(it.name)
    }

    val total = courses.map { it.fee }.reduce { a, b -> a + b }
    println("\nTotal Fees: $total")

    val grouped = courses.groupBy { it.fee }
    println("\nCourses Grouped by Fee:")
    println(grouped)
}
