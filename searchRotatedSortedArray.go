// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * Since this was originally a sorted array, any rotation will still guarantee
 * that at least one half of the sorted array is sorted. So we perform binary
 * search on each half, and eliminate the other half, in a loop, until we either
 * find the element or return -1
 */

package main

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	low, high := 0, len(nums)-1

	for low <= high {
		mid := low + (high-low)/2 // prevent int overflow

		if nums[mid] == target {
			return mid
		}

		// check which half is sorted, as one half is guaranteed to be sorted
		if nums[low] <= nums[mid] { // left half is sorted
			if target >= nums[low] && target < nums[mid] { // target may be in left half, move left
				high = mid - 1
			} else { // otherwise target is in right half
				low = mid + 1
			}
		} else { // right half is sorted
			if target > nums[mid] && target <= nums[high] { // target may be in right half, move right
				low = mid + 1
			} else {
				high = mid - 1
			}
		}
	}

	return -1
}
