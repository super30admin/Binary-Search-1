
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No (needs premium subscription)
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if no elements exist return -1

we can use normal binary search only need to find the range we need to search for
we can double the range starting from 1 to find the element above target that will be our range

if not found return -1
*/
package main

import "fmt"

func searchUnknown(nums []int, target int) int {
	if nums[0] == 2147483647 {
		return -1
	}
	if nums[0] == target {
		return 0
	}
	if nums[1] == 2147483647  {
		return -1
	}
	low := 0
	high := 1
	for nums[high] < target {
		low = high + 1
		high = high * 2
	}
	return BinarySearch(nums, target, low, high)

}

func BinarySearch(nums []int, target int, low int, high int) int {
	for low <= high {
		mid := low + (high - low)/2

		if nums[mid] == target { return mid }
		if nums[mid] < target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func MainSearchUnknownSize() {
	nums := []int {5,7,8,9,10}
	target := 8

	fmt.Println(searchUnknown(nums, target)) // expected 3
}
