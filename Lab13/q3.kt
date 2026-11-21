class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    // Accept / update student data from user input
    fun updateData() {
        print("Enter roll number: ")
        rollNo = readln().trim().toInt()

        print("Enter name: ")
        name = readln().trim()

        print("Enter course: ")
        course = readln().trim()

        print("Enter percentage: ")
        percentage = readln().trim().toDouble()
    }

    // Display all details in a formatted manner
    fun displayDetails() {
        println("--------------------------------")
        println("Roll No    : $rollNo")
        println("Name       : $name")
        println("Course     : $course")
        println("Percentage : ${"%.2f".format(percentage)}%")
        println("--------------------------------")
    }
}

fun main() {
    // Objects created using the primary constructor
    val s1 = Student(101, "Sneha", "B.Tech CSE", 82.5)
    val s2 = Student(102, "Rahul", "B.Tech IT", 76.0)

    println("=== Initial details of Student 1 ===")
    s1.displayDetails()

    println("\n=== Update Student 1 ===")
    s1.updateData()
    s1.displayDetails()

    println("\n=== Initial details of Student 2 ===")
    s2.displayDetails()

    println("\n=== Update Student 2 ===")
    s2.updateData()
    s2.displayDetails()
}