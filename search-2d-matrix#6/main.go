package main

import "fmt"

/*

There are many ways of solving this problem, but for given scenario going to focus on the optimal solution.

- one way is linear search over the entire matrix
- one way can be to see if target is greater than last element in a given row and if yes then iterate over rows until you find a row and then search iteratively over all columns or apply BS on the columns
- one can be to do BS on the elements of first column and find the desired row and then do BS on that entore row - this is optimal solution
- one can be flattend the matrix and then just do a normal BS - this is the way we are going to solve this

What is Binary Search?
- A way of solving a given problem where you can reduce the search time by half.
- Time complexity is logN to the base of 2. Why base of 2? because we are reducing the time by half.

Pattern?
One pattern that this question teaches you is how to find the coordinate of an element in a 2D array given a 1D array. In other words if you were to convert a 2D array into a 1D array, what would be the
coordinates of a given element in that 2D array?

*/

func searchMatrix(matrix [][]int, target int) bool {

	// whenever you are given a matrix : think m X n; i.e. rows X columns and get the number of rows and columns of the matrix
	// getting length of columns
	m := len(matrix)
	// getting length of the inner array at row 0
	n := len(matrix[0])
	fmt.Println("row, column", m, n)

	// number of elements in a 1D array will be
	numberOfElements := m * n
	// assign low and high pointer
	low := 0
	high := numberOfElements

	for low <= high {

		// TODO : read more about int overflow in golang
		// when value of high is too high some languages might result in an int overflow and hence the mid value will be convoluted/polluted and hence avoid doing low + high / 2
		mid := low + (high-low)/2
		midValueRow := mid / n
		midValueColumn := mid % n
		// if the index is going out ot bound
		if midValueRow >= m || midValueColumn >= n {
			return false
		}
		if target == matrix[midValueRow][midValueColumn] {
			return true
		}
		if target > matrix[midValueRow][midValueColumn] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return false
}

func main() {
	found := searchMatrix([][]int{
		[]int{1, 3, 5, 7},
		[]int{10, 11, 16, 20},
		[]int{23, 30, 34, 60},
	}, 3)
	fmt.Println("element found : ", found)
}
