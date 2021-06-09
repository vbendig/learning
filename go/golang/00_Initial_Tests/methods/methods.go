package main

import (
	"fmt"
	"math"
)

type MyFloat float64

type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func (v MyFloat) Abs() float64 {
	return math.Sqrt(float64(v*v))
}

func main() {
	v := Vertex{3, 4}
	fmt.Println(v.Abs())
	f := MyFloat(-3.5)
	fmt.Println(f.Abs())
}
