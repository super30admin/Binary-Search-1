
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if no elements exist return -1
using binary search so break array into left, right parts till both reach same value
break based on mid index
if mid has the value return mid
if left of mid is sorted and target is in left range move high to mid-1 else move low to mid+1
else check if target is in right range move low to mid+1 else move high to mid-1
if not found return -1
*/
package main

import "fmt"

func search(nums []int, target int) int {
	if len(nums) == 0 { return -1 }
	low := 0
	high := len(nums) -1

	for low<=high {
		mid := low + (high-low)/2
		if nums[mid] == target {
			return mid
		}
		if (nums[low]<=nums[mid]) {
			if(nums[low]<= target && target< nums[mid]) {
				high = mid - 1
			} else {
				low = mid + 1
			}
		} else {
			if(nums[mid] < target && target<=nums[high]) {
				low = mid + 1
			} else {
				high = mid - 1
			}
		}
	}
	return -1
}

func MainRotatedSearch() {
	nums := []int {4,5,6,7,0,1,2}
	target := 0

	fmt.Println(search(nums, target)) // expected 4
}
