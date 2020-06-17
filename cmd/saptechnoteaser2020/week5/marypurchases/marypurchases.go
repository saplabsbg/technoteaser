package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

var denominations = []int{500, 200, 100, 50, 20, 10, 5, 2, 1}

// money represents money as numbers of bills of certain denominations.
type money struct {
	bills map[int]int
}

// newMoney creates a new money with the given number of bills of the given denomination.
func newMoney(denomination, number int) *money {
	m := &money{
		bills: make(map[int]int, len(denominations)),
	}
	m.bills[denomination] = number
	return m
}

// newMoneyFromTotal creates a new money from the given total amount.
func newMoneyFromTotal(total int) *money {
	m := &money{
		bills: make(map[int]int, len(denominations)),
	}
	for i := 0; total > 0 && i < len(denominations); i++ {
		d := denominations[i]
		if total >= d {
			m.bills[d] += total / d
			total %= d
		}
	}
	return m
}

// copy creates and returns a copy of this money.
func (m *money) copy() *money {
	x := &money{
		bills: make(map[int]int, len(denominations)),
	}
	for d, n := range m.bills {
		x.bills[d] = n
	}
	return x
}

// String returns a string representation of this money, e.g. [5:1,2:2,1:3]
func (m *money) String() string {
	var b strings.Builder
	b.WriteString("[")
	for _, d := range denominations {
		if m.bills[d] > 0 {
			if b.Len() > 1 {
				b.WriteString(",")
			}
			b.WriteString(strconv.Itoa(d))
			b.WriteString(":")
			b.WriteString(strconv.Itoa(m.bills[d]))
		}
	}
	b.WriteString("]")
	return b.String()
}

// number returns the total number of bills of this money. 
func (m *money) number() int {
	number := 0
	for _, n := range m.bills {
		number += n
	}
	return number
}

// total returns the total amount of this money.
func (m *money) total() int {
	total := 0
	for d, n := range m.bills {
		total += d * n
	}
	return total
}

// add adds the given money to this money.
func (m *money) add(x *money) *money {
	for d, n := range x.bills {
		m.addBills(d, n)
	}
	return m
}

// subtract subtracts the given money from this money.
func (m *money) subtract(x *money) *money {
	for d, n := range x.bills {
		m.subtractBills(d, n)
	}
	return m
}

// addBills add the given number of bills of the given denomination to this money.
func (m *money) addBills(denomination, number int) *money {
	m.bills[denomination] += number
	return m
}

// subtractBills subtracts the given number of bills of the given denomination from this money.
func (m *money) subtractBills(denomination, number int) *money {
	m.bills[denomination] -= number
	if m.bills[denomination] == 0 {
		delete(m.bills, denomination)
	}
	return m
}

var amountsCache = make(map[string]map[int]*money)

// amounts returns all amounts that can be paid exactly with this money.
// The result is a map where the key is the amount and the value is the money representing this amount.
// It uses a cache to avoid recalculating results that have been already calculated.
func (m *money) amounts() map[int]*money {
	// If empty bills, return an empty result
	if len(m.bills) == 0 {
		return make(map[int]*money)
	}

	// Check if the result is already present in the cache
	key := m.String()
	if result, ok := amountsCache[key]; ok {
		return copy(result)
	}

	// Choose an existing denomination at random 
	var d int
	for d = range m.bills {
		break
	}

	// Get all amounts that can be paid exactly without one bill of the chosen denomination
	amounts := m.copy().subtractBills(d, 1).amounts()

	// Add all amounts created by adding the chosen denomination to the previous amounts
	amountsKeys := keys(amounts)
	amounts[d] = newMoney(d, 1)
	for _, amount := range amountsKeys {
		amounts[amount+d] = amounts[amount].copy().addBills(d, 1)
	}

	// Store the result in the cache and return it
	amountsCache[key] = copy(amounts)
	return amounts
}

// copy creates and returns a copy of the given map[int]*money. 
func copy(m map[int]*money) map[int]*money {
	x := make(map[int]*money, len(m))
	for k, v := range m {
		x[k] = v
	}
	return x
}

// keys returns the keys of the given map[int]*money as an unsorted slice.
func keys(m map[int]*money) []int {
	var keys []int
	for key := range m {
		keys = append(keys, key)
	}
	return keys
}

// max returns the larger of the two given numbers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// spendMoney spends the given money according to the problem description, and returns the maximum number of purchases.
// It uses a cache to avoid recalculating results that have been already calculated.
func spendMoney(m *money, cache map[string]int) int {
	// Check if the result is already present in the cache
	key := m.String()
	if result, ok := cache[key]; ok {
		return result
	}

	// Get the total amount
	total := m.total()

	// Get all amounts that can be paid exactly
	amounts := m.amounts()

	// If all amounts from 1 to total can be paid exactly, return 0
	if len(amounts) == total {
		cache[key] = 0
		return 0
	}

	// Sort the amounts to enable searching
	amountsKeys := keys(amounts)
	sort.Ints(amountsKeys)

	// Iterate over all prices from 1 to total and determine maxCount
	maxCount := 0
	for price := 1; price <= total; price++ {
		// Make sure that the price can't be paid exactly
		if _, ok := amounts[price]; ok {
			continue
		}

		// Find the minimum amount larger than price that can be paid exactly
		amount := amountsKeys[sort.SearchInts(amountsKeys, price)]

		// Calculate the change and make sure that it contains at least 2 bills
		change := newMoneyFromTotal(amount - price)
		if change.number() < 2 {
			continue
		}

		// Subtract the money paid and add back the change
		x := m.copy().subtract(amounts[amount]).add(change)

		// Spend the remaining money and set maxCount
		maxCount = max(spendMoney(x, cache)+1, maxCount)
	}

	// Store the result in the cache and return it
	cache[key] = maxCount
	return maxCount
}

func main() {
	fmt.Println(spendMoney(newMoney(100, 1), make(map[string]int)))
}
