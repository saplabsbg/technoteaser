package main

import (
	"fmt"
)

func countNecklaces(necklace string, y, b, r int, gen map[string]bool) int {
	if y == 0 && b == 0 && r == 0 {
		if gen[necklace] {
			return 0
		}
		necklacex := reverse(necklace)
		for i := 0; i < len(necklace); i++ {
			gen[necklace[i:]+necklace[0:i]] = true
			gen[necklacex[i:]+necklacex[0:i]] = true
		}
		return 1
	} else {
		count := 0
		if y > 0 {
			count += countNecklaces(necklace+string('y'), y-1, b, r, gen)
		}
		if b > 0 {
			count += countNecklaces(necklace+string('b'), y, b-1, r, gen)
		}
		if r > 0 {
			count += countNecklaces(necklace+string('r'), y, b, r-1, gen)
		}
		return count
	}
}

func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	fmt.Println(countNecklaces("", 1, 1, 1, make(map[string]bool)))
}
