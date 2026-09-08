package main

import "fmt"

func main() {
	var element1 int

	var element2 int
	fmt.Scan(&element1)
	fmt.Scan(&element2)
	var sum int
	sum = element1 + element2
	println("sum:", sum)
	var subtraction int
	subtraction = element1 - element2
	println("subtraction:", subtraction)
	var multiply int
	multiply = element1 * element2
	println("multiplication:", multiply)

}
