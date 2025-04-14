package main

import "fmt"

/*

There is Array, then comes sorted array and then comes Rotated Sorted Array.
Rotated Sorted Array is nothing but an array that has one half that is sorted and other half that looks unsorted, but if you find the pivot and start iterating on the array from the pivot point then everything returedn to your would be sorted.

Ask of the question : search in log N a given number in the sorted array

Ways of solving the question?

- Linear Search, obviosuly since we have to do in log N, this wont be accepted, but yeah would work as brute force
- set low at 0 and high at len of array and start BS

*/

func search(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	// algo
	for low <= high {
		mid := low + ((high - low) / 2)
		if target == nums[mid] {
			return mid
		}
		// check where is the sorted array
		if nums[low] <= nums[mid] {
			// left is sorted array
			// check if target is in sorted array
			if target >= nums[low] && target < nums[mid] {
				high = mid - 1
			} else {
				low = mid + 1
			}
		} else {
			// right is sorted
			// check if target is in the range of sorted array
			// this is basically helping us reduce the search time as we can target either side of mid after comparing target with mid value
			if target > nums[mid] && target <= nums[high] {
				low = mid + 1
			} else {
				// if target is not in sorted array then its definitely in the unsorted array
				// and that lies other side of mid
				high = mid - 1
			}
		}
	}
	return -1

}

func main() {
	found := search([]int{4, 5, 6, 7, 0, 1, 2}, 0)
	if found == -1 {
		fmt.Println("Element not found")
	} else {
		fmt.Println("Element found at index", found)
	}
}
