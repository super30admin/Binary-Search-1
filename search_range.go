
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : dealt with 2d array

// Your code here along with comments explaining your approach
/*
if no elements exist return [-1, -1]

search for lower and upper limits separately

for lower use normal binary search with extra condition either mid = low or element below mid is less than mid value
for higher use normal binary search with extra condition either mid = high or element above mid is more than mid value
return [lower, higher]
if not found return [-1, -1]
*/
package main

import "fmt"

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 { return []int { -1, -1 }}
	left := binLower(nums, target)
	right := binHigher(nums, target)
	return []int{left, right}
}

func binLower(nums []int, t int) int {
	low := 0
	high := len(nums) - 1

	for low<=high {
		mid := low + (high - low)/2

		if nums[mid] == t {
			if mid == low || nums[mid] > nums[mid - 1] {
				return mid
			} else {
				high = mid - 1
			}
		} else if nums[mid] > t {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}

func binHigher(nums []int, t int) int {
	low := 0
	high := len(nums) - 1

	for low<=high {
		mid := low + (high - low)/2

		if nums[mid] == t {
			if mid == high || nums[mid] < nums[mid + 1] {
				return mid
			} else {
				low = mid + 1
			}
		} else if nums[mid] > t {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}

func MainSearchRange() {
	nums := []int {5,7,7,8,8,10}
	target := 8

	fmt.Println(searchRange(nums, target)) // expected [3,4]
}
