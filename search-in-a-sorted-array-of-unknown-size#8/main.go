package main

import "fmt"

/*

Gotchas : size of the array is unknown, so basically you cannot find the length of the array. Even though if you could find it, do you think that would have been
accomplished in log N time?

Though Process :
- have two pointers : low and high
_ low is going to be 0 and high is going to be 1
- if target is not between low and high then increase high by 2 times and low becomes new high : why 2? - we can increase the number of objects we
scan or go over in between low and high pointer by making high = high*3 or high *4 - but thid would eventually make us iterate over more elements eventually.

Other ways of solving the problem - ?
- set high to max int and then start looking for target?

*/

// subs ArrayReader with limited size array for now and test the solution as there is no Premium for leetcode yet for me
// time complexity : we have one for loop that runs until it exhausts all avail option and that is going to be O(n) - but once range is found the seach is goint ot be O(log2N)
// space : not allocating anything extra so O(1)
// questions/challenges - should the low and high be found in a separate for loop and search be run in a separate for loop?
func search(reader []int, target int) int {
	// set low and high
	low := 0
	high := 1
	for low <= high {
		if target >= reader[low] && target <= reader[high] {
			// number is in between low and high
			mid := low + (high-low)/2 // to avoid int overflow
			if target == reader[mid] {
				return mid
			}
			// check if target is on which side of mid
			if target > reader[mid] {
				// i.e its on right side : move low to mid +1. Mid+1 because we have already looked for if target == middle before the if condition
				low = mid + 1
			} else {
				// the target is on left side of mid and hence mov high to mid -1
				high = mid - 1
			}
		} else {

			// this means that the target is not in range and hence increase the search boundary by increase high
			// also change low as we do not want to iterate over elements that we have already checked
			low = high
			high = high * 2
			fmt.Println(high)
		}
	}

	return -1 // target was not found
}

func main() {
	found := search([]int{-1, 0, 3, 5, 9, 12}, 9)
	fmt.Println("Found target at", found)
}
