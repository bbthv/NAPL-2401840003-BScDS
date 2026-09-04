package mathutil

func Reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func CountVowels(s string) int {
	count := 0
	for _, r := range s {
		switch r {
		case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
			count++
		}
	}
	return count
}

func Factorial(n int) int {
	if n < 0 {
		return -1 // Return -1 for negative numbers
	}
	if n == 0 {
		return 1 // Base case: 0! = 1
	}
	result := 1
	for i := 1; i <= n; i++ {
		result *= i
	}
	return result
}

func Power(base, exponent int) int {
	if exponent < 0 {
		return -1 // Return -1 for negative exponents
	}
	result := 1
	for i := 0; i < exponent; i++ {
		result *= base
	}
	return result
}
