package main

import (
	"fmt"
	"math"
)

func nearestSqrt(x, initialVal, margin float64) (z float64) {
	//z -= (z*z - x) / (2*z)
	z = initialVal
	currz := z
	var diff float64

	for i := 0; i < 10; i++ {
		if z*z == x {
			return
		} else {
			z -= (z*z - x) / (2 * z)
		}
		fmt.Printf("Z is %v\n", z)
		fmt.Printf("CurrZ is %v\n", currz)
		fmt.Printf("diff is %v\n", currz - z)
		diff = math.Abs(currz - z)
		if z == currz || math.Abs(currz - z) < margin {
			break
		} else {
			currz = z
		}
	}
	fmt.Printf("Z is %v\n", z)
	upper := z*z - x
	lower := ( z - diff ) * ( z- diff ) - x
	fmt.Printf("upper z is %v and z^2 is %v with a diff of %v\n", z, z*z, math.Abs(float64(upper)))
	fmt.Printf("lower z is %v and z^2 is %v with a diff of %v\n", z - diff, (z-diff)*(z-diff), math.Abs(float64(lower)))
	if math.Abs(float64(upper)) > (math.Abs(float64(lower))) {
		z--
	}
	return
}

func main() {
	var numeroInicial float64 = 17
	fmt.Printf("Number is %v\n", numeroInicial)
	result := nearestSqrt(numeroInicial, 1, 0.001)
	fmt.Printf("Resultado %v", result)
}
