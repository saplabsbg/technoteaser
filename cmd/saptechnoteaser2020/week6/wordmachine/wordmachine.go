package main

import (
	"fmt"
	"math"
)

var alphabet = []rune("АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЬЮЯ")
var prices map[rune]int

func init() {
	prices = make(map[rune]int, 30)
	p := 1
	for _, r := range alphabet {
		prices[r] = p
		p++
	}
}

type machine struct {
	state []rune
}

func newMachine(s string) *machine {
	return &machine{
		state: []rune(s),
	}
}

func (m *machine) String() string {
	return string(m.state)
}

func (m *machine) empty() bool {
	return len(m.state) == 0
}

func (m *machine) len() int {
	return len(m.state)
}

func (m *machine) contains(r rune) bool {
	for _, x := range m.state {
		if x == r {
			return true
		}
	}
	return false
}

func (m *machine) positions(r rune) []int {
	var positions []int
	for i, x := range m.state {
		if x == r {
			positions = append(positions, i)
		}
	}
	return positions
}

func (m *machine) add(letter rune) int {
	m.state = append(m.state, letter)
	return prices[letter]
}

func (m *machine) remove() (rune, int) {
	letter := m.state[len(m.state)-1]
	m.state = m.state[:len(m.state)-1]
	return letter, prices[letter]
}

func (m *machine) increment() int {
	for i := 0; i < len(m.state); i++ {
		if m.state[i] == 'Ъ' || m.state[i] == 'Ь' {
			m.state[i] += 2
		} else {
			m.state[i]++
		}
	}
	return 2
}

func (m *machine) decrement() int {
	for i := 0; i < len(m.state); i++ {
		if m.state[i] == 'Ь' || m.state[i] == 'Ю' {
			m.state[i] -= 2
		} else {
			m.state[i]--
		}
	}
	return 2
}

func (m *machine) shiftRight(i, j int) int {
	x := m.state[i]
	for k := i; k < j; k++ {
		m.state[k] = m.state[k+1]
	}
	m.state[j] = x
	return j - i
}

func (m *machine) shiftLeft(j, i int) int {
	x := m.state[j]
	for k := j; k > i; k-- {
		m.state[k] = m.state[k-1]
	}
	m.state[i] = x
	return j - i
}

// findMinCostStoyan finds the lowest cost of getting from the given machine to an empty machine
// using remove, decrement, and right-shift operations.
// It uses a cache to avoid recalculating results that have been already calculated.
// The allowShifts flag controls whether shifts are allowed or not, 
// to ensure that all shifts are performed in the beginning.
func findMinCostStoyan(m *machine, cache map[string]int, allowShifts bool) int {
	// Check for empty state
	if m.empty() {
		return 0
	}

	// Check if the result is already present in the cache
	key := m.String()
	if result, ok := cache[key]; ok {
		return result
	}

	// Initialize minCost
	minCost := math.MaxInt64

	// Perform decrement if possible, otherwise perform remove
	if !m.contains('А') && m.len() >= 3 {
		cost := m.decrement()
		minCost = min(cost+findMinCostStoyan(m, cache, false), minCost)
		m.increment()
	} else {
		letter, cost := m.remove()
		minCost = min(cost+findMinCostStoyan(m, cache, false), minCost)
		m.add(letter)
	}

	// Check if shifts are allowed, to ensure that all shifts are performed in the beginning 
	if allowShifts {
		// For all pairs of positions i and j so that j > i and j > 2, 
		// check if a shift from i to j could lower the cost and if yes, perform it
		for i := 0; i < m.len()-1; i++ {
			for j := max(2, i) + 1; j < m.len(); j++ {
				if shiftCouldLowerCost(m, i, j) {
					cost := m.shiftRight(i, j)
					minCost = min(cost+findMinCostStoyan(m, cache, true), minCost)
					m.shiftLeft(j, i)
				}
			}
		}
	}

	// Store the result in the cache and return it
	cache[key] = minCost
	return minCost
}

// shiftCouldLowerCost returns true if the right-shift from i to j could potentially lower the cost
// of getting from the given machine to an empty machine using remove, decrement, and additional right-shift operations.
// The above is true if the j-th letter is more expensive than the i-the letter, and there is an interval [s:j)
// where s <= i, such that:
//	- there are no letters cheaper than the i-th letter 
//	- there are at least 2 other letters more expensive than the i-th letter
func shiftCouldLowerCost(m *machine, i, j int) bool {
	// Ensure that j-the letter is more expensive than the i-th letter
	if prices[m.state[j]] <= prices[m.state[i]] {
		return false
	}

	// Ensure that there is an interval [s:j) where s <= i, such that:
	count := 0
	for k := j - 1; k >= i || (k >= 0 && count < 2); k-- {
		if k == i {
			continue
		} else if prices[m.state[k]] < prices[m.state[i]] {
			// - there are no letters cheaper than the i-th letter
			return false
		} else if prices[m.state[k]] > prices[m.state[i]] {
			count++
		}
	}
	if count < 2 {
		// - there are at least 2 other letters more expensive than the i-th letter
		return false
	}

	return true
}

// findMinCostDancho finds the lowest cost of getting from the given machine to an empty machine
// using remove, decrement, and right-shift operations.
// It uses a cache to avoid recalculating results that have been already calculated.
func findMinCostDancho(m *machine, cache map[string]int) int {
	// Check for empty state
	if m.empty() {
		return 0
	}

	// Check if the result is already present in the cache
	key := m.String()
	if result, ok := cache[key]; ok {
		return result
	}

	// Initialize minCost
	minCost := math.MaxInt64

	// Find all positions of 'А'
	positions := m.positions('А')
	if len(positions) == 0 && m.len() >= 3 {
		// There is no 'А' and the length is at least 3, perform decrement
		cost := m.decrement()
		minCost = min(cost+findMinCostDancho(m, cache), minCost)
		m.increment()
	} else if m.len() <= 3 || positions[len(positions)-1] == m.len()-1 || len(positions) > m.len()-2 {
		// The length is 3 or less, or the last letter is 'А', or there are less than 3 letters that are not 'А', perform remove
		letter, cost := m.remove()
		minCost = min(cost+findMinCostDancho(m, cache), minCost)
		m.add(letter)
	} else {
		// Option 1: Perform remove
		letter, cost := m.remove()
		minCost = min(cost+findMinCostDancho(m, cache), minCost)
		m.add(letter)

		// Option 2: Perform right-shift to shift the last 'А' to the end
		cost = m.shiftRight(positions[len(positions)-1], m.len()-1)
		minCost = min(cost+findMinCostDancho(m, cache), minCost)
		m.shiftLeft(m.len()-1, positions[len(positions)-1])
	}

	// Store the result in the cache and return it
	cache[key] = minCost
	return minCost
}

// min returns the smaller of the two given numbers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// max returns the larger of the two given numbers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	// САПТЕХНОБЛЪСКАНИЦА
	cache := make(map[string]int)
	fmt.Println(findMinCostStoyan(newMachine("САПТЕХНОБЛЪСКАНИЦА"), cache, true))
	// fmt.Println(findMinCostDancho(newMachine("САПТЕХНОБЛЪСКАНИЦА"), cache))
}
