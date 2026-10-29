package main

import "fmt"

func square(ch chan int, num int) {
	fmt.Println("square goroutine started")
	result := num * num
	fmt.Println("square goroutine finished")
	ch <- result
}
func cube(ch chan int, num int) {
	fmt.Println("cube goroutine started")
	result := num * num * num
	fmt.Println("cube goroutine finished")
	ch <- result
}
func fibonacci(ch chan int, num int) {
	fmt.Println("fibonacci goroutine started")
	a, b := 0, 1
	for i := 0; i < num; i++ {
		a, b = b, a+b
	}
	fmt.Println("fibonacci goroutine finished")
	ch <- a
}

func main() {
	var num int
	fmt.Print("Enter a number: ")
	fmt.Scan(&num)
	resultCh := make(chan int)
	go square(resultCh, num)
	go cube(resultCh, num)
	go fibonacci(resultCh, num)
	fmt.Printf("Square: %d\n", <-resultCh)
	fmt.Printf("Cube: %d\n", <-resultCh)
	fmt.Printf("Fibonacci: %d\n", <-resultCh)
}
