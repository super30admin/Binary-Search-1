package main

/*

Why does binary search work for this input?
-- REMEMBER: IF ITS SOMEWHAT SORTED - there is a potential of binary search with some other rule....
-- because "wherever with some rule we can repeatedly reduce the search space by half, we can use binarySearch"
-- We just have to find with what "rule" we can repeatedly reduce the search space by half


In this problem, even tho the whole array is not sorted,
but there WILL ALWAYS BE A SORTED SIDE IN ASCENDING ORDER


[4,5,6,7,0,1,2]
4,5,6,7 is sorted in ascending order
0,1,2 is also sorted but on the wrong side ( still sorted within its chunk)

[7,8,9,10,1,2,3,4,5,6]
7,8,9,10 is sorted in ascending order
1,2,3,4,5,6 is also sorted but on the wrong side ( still sorted within its chunk)


So we can repeatedly cut search window by half using binarySearch
if left <= mid
    ( meaning the leftest value which should be smaller if in ascending order when compared to mid )
    if the leftest value is <= ( smaller or equalTo ) midValue
    - left side is sorted in ascending


ok, but how does that help in this problem?

Example [7,8,9,10,1,2,3,4,5,6]
Search: 9


[7,8,9,10,1,2,3,4,5,6]
 L          M       R
len/2 - 5
mid = 5 (idx)
midValue = 2
left <= mid - No its not sorted ( 7 <= 5 -- no )
So then we can imply right side of mid is sorted

However that does not mean that the target is on the right side ( we can sort of assume )

But then before deciding where Left pointer moves
    - we can check whether our target <= rigthest ptr val
    - this works because if right is sorted, the last value (right ptr) is the greatest value available
    - if our target <= biggestValueOnRight ($right )
    - move left to mid+1
    - else
    - move right to mid-1

Apply the inverse of the above if left side turns out to be sorted

TLDR:
- find the sorted half from mid's perspective
- ONLY search in the sorted half if your target is within the sorted half range
- Otherwise search on the other side (unsorted side)

time: o(logn)
space: o(1)
*/

func search(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) / 2)
		if nums[mid] == target {
			return mid
		} else if nums[mid] >= nums[left] {
			// left sorted
			if target >= nums[left] && target < nums[mid] {
				// target is within left sorted range
				right = mid - 1
			} else {
				// even tho from mids perspective,
				// left is sorted but left sorted range does not include target
				// therefore search right
				left = mid + 1
			}
		} else {
			// right sorted
			if target > nums[mid] && target <= nums[right] {
				// target is within left sorted range ?
				left = mid + 1
			} else {
				// even tho from mids perspective,
				// right is sorted but right sorted range does not include target
				// therefore search left
				right = mid - 1
			}
		}
	}
	return -1

}
