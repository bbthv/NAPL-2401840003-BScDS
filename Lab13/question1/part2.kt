fun main() {
    print("Enter department code (IT / HR / FIN / other): ")
    val deptCode = readln().trim().uppercase()

    print("Enter years of experience: ")
    val years = readln().trim().toInt()

    print("Enter salary: ")
    val salary = readln().trim().toDouble()

    val bonusPercent = when {
        deptCode == "IT" && years > 5  -> 20
        deptCode == "HR" && years > 3  -> 15
        deptCode == "FIN" && years > 4 -> 12
        else                           -> 10
    }

    val bonus = salary * bonusPercent / 100

    println("Department : $deptCode")
    println("Experience : $years years")
    println("Bonus rate : $bonusPercent%")
    println("Bonus amount: $bonus")
}