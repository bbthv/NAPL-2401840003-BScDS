package main

import "slices"
import "fmt"

func main() {
	s := []int{}
	fmt.Println("Empty slice:", s)
	fmt.Println("enter the number of elements")
	var size int
	fmt.Scan(&size)
	for i := 0; i < size; i++ {
		fmt.Print("Enter element ", i+1, ": ")
		var element int
		fmt.Scan(&element)
		s = append(s, element)
	}
	//s = append(s, 10, 20, 30, 40)
	fmt.Println("Slice after appending:", s)
	s = slices.Delete(s, 1, 3) // element at index 1 and 2 will be deleted
	fmt.Println("Slice after deleting element at index 1 and 2:", s)
	//update
	s[0] = 2
	fmt.Println("slice after updating element at index 0", s)
	s[1] = 4
	fmt.Println("slice after updating element at index 1", s)
	fmt.Println(s)

	// implementing maps
	subjects := map[string]int{}
	//inserting values
	subjects["Math"] = 70
	fmt.Println("after inserting math:", subjects)
	subjects["English"] = 80
	fmt.Println("after inserting english:", subjects)
	subjects["Hindi"] = 85
	fmt.Println("after inserting hindi:", subjects)
	//deleting values
	delete(subjects, "English")
	fmt.Println("after deleting english:", subjects)
	//look up operation
	for k, v := range subjects {
		fmt.Println("Key:", k, "Value:", v)
	}

}
