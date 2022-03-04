package main

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * type ArrayReader struct {
 * }
 *
 * func (this *ArrayReader) get(index int) int {}
 */

/*
   "You have a sorted array of unique" -- think binary search

   "and an unknown size" -- if binary search, this means that we do not have a left & right ptrs so start with right away
       -- this does not mean we cannot do binary search

       - we can instead using the doubling logic to find the left and right ptrs
       - normally in a binary search, we cut down our window to search by half each time
       - then the inverse also applies
       - we can increase idx by 2 in each iteration until we run into a value <= target
       - meaning we can start left at 0
       - start right at 1
       - get(right)
       - if value > target -- this means we have a window in which left < target < right
       - we can make the above assumption because "You have a sorted array"
       - and in iteration we stepped by 2 to find the right pointer ( increasing by 2 )

       - once we have left and right, then a classic binary search since elements within are sorted
*/

type ArrayReader struct{}

func (this *ArrayReader) get(index int) int { panic("TODO") }

func search(reader ArrayReader, target int) int {

	left := 0
	right := 1

	for reader.get(right) < target {
		left = right
		right = right * 2
	}

	for left <= right {
		mid := left + ((right - left) / 2)
		if reader.get(mid) == target {
			return mid
		} else if target < reader.get(mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return -1
}
