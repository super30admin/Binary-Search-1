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
*/

func search(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	/*
	   [7,8,9,10,1,2,3,4,5,6]
	    L          M       R
	*/
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) / 2)
		if nums[mid] == target {
			return mid
		} else if nums[left] <= nums[mid] {
			// left is sorted side
			// but is our target within left and mid
			// left will be the smallest number -- so target must be >= left but < nums[mid]
			if target >= nums[left] && target < nums[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			// right is sorted side
			// but is our target within the last value
			if target <= nums[right] && target > nums[mid] {
				left = mid + 1
			} else {
				// meaning even tho right is sorted
				// out target value is way past the highest value(right) available
				// so check left
				right = mid - 1
			}
		}
	}
	return -1

}
