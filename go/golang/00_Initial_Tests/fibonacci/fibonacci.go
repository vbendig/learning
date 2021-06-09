package main

import "fmt"

// fibonacci is a function that returns
// a function that returns an int.
func fibonacci() func() int {
	curr := 1
	prev := 0
	return func() int{
		val := prev
		result := curr + prev 
		prev = curr
		curr = result
		return val
	}
}

func main() {
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}