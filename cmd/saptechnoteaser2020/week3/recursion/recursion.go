package main

import "fmt"

func f(n int) int {
	fmt.Printf("f(%d)\n", n)
	if n > 2020 {
		return n - 3
	} else {
		return fpower(n, 4*n)
	}
}

func fpower(p, n int) int {
	fmt.Printf("fpower(%d, %d)\n", p, n)
	if p == 1 {
		return f(n)
	} else {
		return f(fpower(p-1, n))
	}
}

func main() {
	fmt.Println(f(1))
}
