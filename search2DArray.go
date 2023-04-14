// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * Since the guarantee for this problem is that any element in a row is smaller
 * than any element in the next row, we can consider this 2D array as a flat
 * sorted 1D array, and apply binary search on it. Note that the main change
 * here is the conversion of the "mid" into coordinates of the 2D array.
 */

package main

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	m, n := len(matrix), len(matrix[0])

	low := 0
	high := m*n - 1

	for low <= high {
		mid := low + (high-low)/2 // prevent int overflow
		x, y := mid/n, mid%n
		if matrix[x][y] == target {
			return true
		}

		if matrix[x][y] < target { // move right
			low = mid + 1
		} else { // move left
			high = mid - 1
		}
	}

	return false
}
