package main

import (
	"fmt"
	"sort"
)

const maxPrimes = 100000000

// primes is a boolean slice initialized so that primes[n] = true if n is prime.
var primes []bool

// initPrimes initializes the global variable primes up to the given number
// using the Sieve of Eratosthenes (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).
func initPrimes(n int) {
	primes = make([]bool, n+1)
	for i := 2; i <= n; i++ {
		primes[i] = true
	}
	for i := 2; i*i <= n; i++ {
		if primes[i] {
			for j := i * 2; j <= n; j += i {
				primes[j] = false
			}
		}
	}
}

type category int

// Categories
const (
	// deficient: the sum of the divisors of n is less than 2n, not perfect or abundant (see https://oeis.org/A005100).
	deficient category = iota
	// pseudoperfect (including perfect): some subset of the divisors of n sums up to n (see https://oeis.org/A005835).
	pseudoperfect
	// weird: abundant but not pseudoperfect (see https://oeis.org/A006037)
	weird
)

func (c category) String() string {
	switch c {
	case deficient:
		return "deficient"
	case pseudoperfect:
		return "pseudoperfect"
	case weird:
		return "weird"
	default:
		return "?"
	}
}

func isWeird(n int) bool {
	return categorize(n) == weird
}

var cache = make(map[int]category)

// categorize determines if the given number is deficient, pseudoperfect, or weird.
// It uses a cache to avoid recalculating results that have been already calculated.
func categorize(n int) category {
	// If the number is prime, it's deficient
	if primes[n] {
		return deficient
	}

	// Check if the result is already present in the cache
	if result, ok := cache[n]; ok {
		return result
	}

	// Determine all divisors of n
	divs := divisors(n)

	// If the sum of all divisors is less than n, n is deficient
	// If it equals n, n is pseudoperfect (actually perfect)
	s := sum(divs...)
	if s < n {
		cache[n] = deficient
		return deficient
	} else if s == n {
		cache[n] = pseudoperfect
		return pseudoperfect
	}

	// Determine the prime factors of n
	primeFactors := primeFactors(n)

	// There are no odd weird numbers < 10^17 (https://oeis.org/A006037)
	if primeFactors[0] > 2 {
		cache[n] = pseudoperfect
		return pseudoperfect
	}

	// If after removing any single prime factor the resulting number is pseudoperfect, n is also pseudoperfect
	// (since a number that is divisible by a pseudoperfect number is also pseudoperfect)
	for i := len(primeFactors) - 1; i >= 0; i-- {
		// Test each prime factor only once
		if i < len(primeFactors)-1 && primeFactors[i] == primeFactors[i+1] {
			continue
		}
		if categorize(n/primeFactors[i]) == pseudoperfect {
			cache[n] = pseudoperfect
			return pseudoperfect
		}
	}

	// A weird number n multiplied with a prime p > sigma(n) is again weird (https://oeis.org/A006037)
	p := primeFactors[len(primeFactors)-1]
	nx := n / p
	if categorize(nx) == weird && p > sum(divisors(nx)...)+nx {
		cache[n] = weird
		return weird
	}

	// If a subset of all divisors of n sums up to n, n is pseudoperfect
	// Otherwise it's weird
	sort.Ints(divs)
	_, sums := sums(s-n, divs...)
	if sums[s-n] {
		cache[n] = pseudoperfect
		return pseudoperfect
	}
	cache[n] = weird
	return weird
}

// categorizeSimple determines if the given number is deficient, pseudoperfect, or weird,
// using a simpler (and slower) algorithm.
func categorizeSimple(n int) category {
	// If the number is prime, it's deficient
	if primes[n] {
		return deficient
	}

	// Determine all divisors of n
	divisors := divisors(n)

	// If the sum of all divisors is less than n, n is deficient
	// If it equals n, n is pseudoperfect (actually perfect)
	s := sum(divisors...)
	if s < n {
		return deficient
	} else if s == n {
		return pseudoperfect
	}

	// If a subset of all divisors of n sums up to n, n is pseudoperfect
	// Otherwise it's weird
	sort.Ints(divisors)
	_, sums := sums(s-n, divisors...)
	if sums[s-n] {
		return pseudoperfect
	}
	return weird
}

var primeFactorsCache = make(map[int][]int)

// primeFactors returns the prime factors of the given number in ascending order.
// It uses a cache to avoid recalculating results that have been already calculated.
func primeFactors(n int) []int {
	if primes[n] {
		return []int{n}
	}
	if result, ok := primeFactorsCache[n]; ok {
		return result
	}
	var result []int
	for x := 2; x <= n/2; x++ {
		if primes[x] && n%x == 0 {
			result = append(result, x)
			result = append(result, primeFactors(n/x)...)
			break
		}
	}
	primeFactorsCache[n] = result
	return result
}

var divisorsCache = make(map[int][]int)

// divisors returns all proper divisors of the given number, 
// including 1 but excluding the number itself.
func divisors(n int) []int {
	if result, ok := divisorsCache[n]; ok {
		return result
	}
	products, _ := products(primeFactors(n)...)
	result := append([]int{1}, products[:len(products)-1]...)
	divisorsCache[n] = result
	return result
}

// sum returns the sum of the given numbers.
func sum(numbers ...int) int {
	sum := 0
	for _, n := range numbers {
		sum += n
	}
	return sum
}

// sums returns all sums of subsets of the given numbers that are less than or equal to the given limit.
// The result is returned as both an (unsorted) slice and a map.
// Note that numbers must be sorted in ascending order for this function to work properly.
func sums(limit int, numbers ...int) ([]int, map[int]bool) {
	if len(numbers) == 0 {
		return nil, make(map[int]bool)
	}
	x := numbers[0]
	if x > limit {
		return nil, make(map[int]bool)
	} else if x == limit {
		return []int{x}, map[int]bool{x: true}
	}
	results, resultsMap := sums(limit, numbers[1:]...)
	var newResults []int
	if !resultsMap[x] {
		newResults = append(newResults, x)
	}
	for _, r := range results {
		nr := r + x
		if nr <= limit && !resultsMap[nr] {
			newResults = append(newResults, nr)
		}
	}
	for _, x := range newResults {
		results = append(results, x)
		resultsMap[x] = true
	}
	return results, resultsMap
}

// products returns all products of subsets of the given numbers.
// The result is returned as both an (unsorted) slice and a map.
func products(numbers ...int) ([]int, map[int]bool) {
	if len(numbers) == 0 {
		return nil, make(map[int]bool)
	}
	x := numbers[0]
	results, resultsMap := products(numbers[1:]...)
	var newResults []int
	if !resultsMap[x] {
		newResults = append(newResults, x)
	}
	for _, r := range results {
		nr := r * x
		if !resultsMap[nr] {
			newResults = append(newResults, nr)
		}
	}
	for _, x := range newResults {
		results = append(results, x)
		resultsMap[x] = true
	}
	return results, resultsMap
}

func main() {
	// Initialize primes
	initPrimes(maxPrimes)

	// Print the first N weird numbers
	count := 0
	for n := 2; n <= maxPrimes && count < 10000; n++ {
		if isWeird(n) {
			count++
			fmt.Printf("%d: %d: %v\n", count, n, primeFactors(n))
		}
	}

	// Test a single number
	// n := 2 * 2 * 2 * 29 * 31 * 37
	// fmt.Println("n:", n)
	// primeFactors := primeFactors(n)
	// fmt.Println("prime factors:", primeFactors)
	// divisors := divisors(primeFactors)
	// sort.Ints(divisors)
	// fmt.Println("divisors:", divisors)
	// s := sum(divisors...)
	// fmt.Println("s:", s)
	// fmt.Println("s-n:", s-n)
	// sums, _ := sums(s-n, divisors...)
	// sort.Ints(sums)
	// fmt.Println("sums:", sums)
	// fmt.Println("categorize:", categorize(n))
	// fmt.Println("categorizeSimple:", categorizeSimple(n))
}
