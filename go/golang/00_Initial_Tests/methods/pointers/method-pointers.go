package main

import (
	"fmt"
	"math"
)

type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func Abs(v Vertex) float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func (v *Vertex) ScaleP(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

func (v Vertex) Scale(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

func Scale(v Vertex, f float64) Vertex {
	v.X = v.X * f
	v.Y = v.Y * f
	return v
}

func ScaleP(v *Vertex, f float64) *Vertex {
	v.X = v.X * f
	v.Y = v.Y * f
	return v
}

func main() {
	v := Vertex{3, 4}
	v.ScaleP(10) //v1 passed explycitly by ref, not by val
	fmt.Println(v.Abs())

	v0 := Vertex{3, 4}
	v0.Scale(10) //v1 passed by value, not by ref
	fmt.Println(v0.Abs())

	v1 := Vertex{3, 4}
	Scale(v1, 10) //v1 passed by value, not by ref
	fmt.Println(Abs(v1))

	v2 := &Vertex{3, 4}
	ScaleP(v2, 10) //v1 passed explycitly by ref, not by val
	fmt.Println(Abs(*v2))

	var v4 *int
	*v4 = 4
	v5 := 44
	v4 = &v5
	var v3 **Vertex 
	v3 = &v2
	fmt.Printf("%T\n", v3)
	fmt.Printf("%T\n", v2)
	fmt.Printf("%T\n", &v3)
	fmt.Printf("%T\n", *&v3)
	fmt.Printf("%T\n", ***&v3)
	fmt.Println(&v3)
	fmt.Println(v3)
	fmt.Println(v2)
	fmt.Println(&v2)
	fmt.Println(*v2)
}
