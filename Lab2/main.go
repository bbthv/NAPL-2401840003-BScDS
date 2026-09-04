package main

import (
	"fmt"

	"Lab2/mathutil"
)

func main() {
	text := "Hello Go"

	fmt.Println("Original:", text)
	fmt.Println("Reversed:", mathutil.Reverse(text))
	fmt.Println("Vowels:", mathutil.CountVowels(text))

	fmt.Println("Factorial of 6:", mathutil.Factorial(6))
	fmt.Println("2 raised to 7:", mathutil.Power(2, 7))
}
