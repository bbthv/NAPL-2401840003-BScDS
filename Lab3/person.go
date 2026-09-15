package main

import (
	"bufio"
	"fmt"
	"os"
)

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float32
}

func (p Person) readInputs() Person {
	var reader = bufio.NewReader(os.Stdin)

	fmt.Print("Enter name:")
	fmt.Scan(&p.Name)
	reader.ReadLine()
	fmt.Print("Enter age:")
	fmt.Scan(&p.Age)
	reader.ReadLine()
	fmt.Print("Enter job:")
	fmt.Scan(&p.Job)
	reader.ReadLine()
	fmt.Print("Enter salary:")
	fmt.Scan(&p.Salary)
	reader.ReadLine()
	return p
}

func (p Person) show() {
	fmt.Printf("Name: %s\n", p.Name)
	fmt.Printf("Age: %d\n", p.Age)
	fmt.Printf("Job: %s\n", p.Job)
	fmt.Printf("Salary: %.2f\n", p.Salary)
}

func main() {
	var p1 Person
	p1 = p1.readInputs()
	p1.show()
	var p2 Person
	p2 = p2.readInputs()
	p2.show()
}
