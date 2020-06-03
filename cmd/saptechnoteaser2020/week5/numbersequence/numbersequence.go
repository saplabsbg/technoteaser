package main

import (
	"fmt"
	"math/big"
)

var binomialCoefficientsCache = make(map[int][]*big.Int)

// binomialCoefficients returns all binomial coefficients (n, k), where k >= 0 and k <= n.
// The coefficients are calculated using the Pascal triangle.
// This function uses a cache to avoid recalculating results that have been already calculated.
func binomialCoefficients(n int) []*big.Int {
	if n == 1 {
		return []*big.Int{big.NewInt(1), big.NewInt(1)}
	}

	// Check if the result is already present in the cache
	if result, ok := binomialCoefficientsCache[n]; ok {
		return result
	}

	// Calculate coefficients
	cs := binomialCoefficients(n - 1)
	result := []*big.Int{big.NewInt(1)}
	for i := 0; i < len(cs)-1; i++ {
		x := new(big.Int)
		x.Set(cs[i])
		result = append(result, x.Add(x, cs[i+1]))
	}
	result = append(result, big.NewInt(1))

	// Store the result in the cache and return it
	binomialCoefficientsCache[n] = result
	return result
}

var cache = make(map[int]*big.Int)

// a returns the value of the n-th polynomial.
// This function uses a cache to avoid recalculating results that have been already calculated.
func a(n int) *big.Int {
	if n == 0 {
		return big.NewInt(1)
	} else if n == 1 {
		return big.NewInt(5)
	}

	// Check if the result is already present in the cache
	if result, ok := cache[n]; ok {
		return result
	}

	// Calculate the value of the n-th polynomial
	cs := binomialCoefficients(n)
	sum := big.NewInt(0)
	for i := 1; i <= n/2; i++ {
		x := new(big.Int)
		x.Set(cs[i])
		sum.Add(sum, x.Mul(x, a(n-2*i)))
	}
	x := big.NewInt(5)
	x.Exp(x, big.NewInt(int64(n)), nil)
	x.Sub(x, sum)

	// Store the result in the cache and return it
	cache[n] = x
	return x
}

func main() {
	fmt.Println(a(2020))
}
