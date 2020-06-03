package main

import (
	"fmt"
	"math"
	"strconv"
)

// op is a type for arithmetic operations.
type op int

// Arithmetic operations
const (
	add op = iota
	sub
	mul
	div
)

// String returns this op as a string.
func (op op) String() string {
	switch op {
	case add:
		return "+"
	case sub:
		return "-"
	case mul:
		return "*"
	case div:
		return "/"
	}
	return ""
}

// prio returns the priority of this op - 1 for add and sub, 2 for mul and div.
func (op op) prio() int {
	switch op {
	case add, sub:
		return 1
	case mul, div:
		return 2
	}
	return 0
}

// expression is a type for expressions. An expression a node in an abstract syntax tree.
type expression interface {
	fmt.Stringer
	Evaluate() float64
}

// constant is a type for constant expressions.
type constant struct {
	value int
}

// newConstant creates a new constant expression.
func newConstant(value int) *constant {
	return &constant{value: value}
}

// String returns a string representation of this constant expression.
func (c *constant) String() string {
	return strconv.Itoa(c.value)
}

// Evaluate evaluates this constant expression to a value.
func (c *constant) Evaluate() float64 {
	return float64(c.value)
}

// arithmetic is a type for arithmetic operation expressions.
type arithmetic struct {
	op          op
	left, right expression
}

// newArithmetic creates a new arithmetic operation expression.
func newArithmetic(op op, left, right expression) *arithmetic {
	return &arithmetic{op: op, left: left, right: right}
}

// String returns a string representation of this arithmetic operation expression.
func (a *arithmetic) String() string {
	return a.left.String() + a.op.String() + a.right.String()
}

// Evaluate evaluates this arithmetic operation expression to a value.
func (a *arithmetic) Evaluate() float64 {
	switch a.op {
	case add:
		return a.left.Evaluate() + a.right.Evaluate()
	case sub:
		return a.left.Evaluate() - a.right.Evaluate()
	case mul:
		return a.left.Evaluate() * a.right.Evaluate()
	case div:
		return a.left.Evaluate() / a.right.Evaluate()
	}
	return 0
}

// sqrt is a type for sqrt expressions.
type sqrt struct {
	arg expression
}

// newSqrt creates a new sqrt expression.
func newSqrt(arg expression) *sqrt {
	return &sqrt{arg: arg}
}

// String returns a string representation of this sqrt expression.
func (s *sqrt) String() string {
	return "sqrt(" + s.arg.String() + ")"
}

// Evaluate evaluates this sqrt expression to a value.
func (s *sqrt) Evaluate() float64 {
	return math.Sqrt(s.arg.Evaluate())
}

// genArithmetic generates all possible arithmetic operation expressions with arguments among the given lefts and rights. 
// Expressions that would require () to build are discarded.
func genArithmetic(lefts, rights []expression) []expression {
	var nodes []expression
	for _, left := range lefts {
		for _, right := range rights {
			for _, op := range []op{add, sub, mul, div} {
				// Skip expressions that would require () to build
				if l, ok := left.(*arithmetic); ok && l.op.prio() < op.prio() {
					continue
				}
				if r, ok := right.(*arithmetic); ok && r.op.prio() <= op.prio() {
					continue
				}
				nodes = append(nodes, newArithmetic(op, left, right))
			}
		}
	}
	return nodes
}

// genSqrt generates all possible sqrt expressions with an argument among the given args. 
// Given an expression x, the sqrt expressions that are considered possible are x, sqrt(x), and sqrt(sqrt(x)).
func genSqrt(args ...expression) []expression {
	var nodes []expression
	for _, arg := range args {
		nodes = append(nodes,
			arg,
			newSqrt(arg),
			newSqrt(newSqrt(arg)),
		)
	}
	return nodes
}

// expr1 generates all possible expressions with one 4.
func expr1() []expression {
	return append([]expression{},
		genSqrt(newConstant(4))...,
	)
}

// expr2 generates all possible expressions with two 4s.
func expr2() []expression {
	return append(append([]expression{},
		genSqrt(newConstant(44))...),
		genSqrt(genArithmetic(expr1(), expr1())...)...,
	)
}

// expr3 generates all possible expressions with three 4s.
func expr3() []expression {
	return append(append(append([]expression{},
		genSqrt(newConstant(444))...),
		genSqrt(genArithmetic(expr1(), expr2())...)...),
		genSqrt(genArithmetic(expr2(), expr1())...)...,
	)
}

// expr4 generates all possible expressions with four 4s.
func expr4() []expression {
	return append(append(append(append([]expression{},
		genSqrt(newConstant(4444))...),
		genSqrt(genArithmetic(expr1(), expr3())...)...),
		genSqrt(genArithmetic(expr2(), expr2())...)...),
		genSqrt(genArithmetic(expr3(), expr1())...)...,
	)
}

func main() {
	// Generate all possible expressions with four 4s, evaluate them, and append the result to the results map
	results := make(map[float64][]expression)
	for _, expr := range expr4() {
		value := expr.Evaluate()
		// fmt.Println(expr.String(), "=>", value)
		results[value] = append(results[value], expr)
	}
	
	// Iterate from 1 to 100 and print all expressions that are evaluated to this value, until there are none
	for i := 1; i <= 100; i++ {
		if trees, ok := results[float64(i)]; ok {
			fmt.Printf("%d: %v\n", i, trees)
		} else {
			break
		}
	}
}
