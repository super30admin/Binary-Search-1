# Problem1
"""
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


"""


def findrotate(nums, target):
    low = 0
    high = len(nums)-1
    while low <= high:
        mid = low+(high-low)//2                # calculate the mid
        if nums[mid] == target:                # check if element at mid == target if yes return mid
            return mid
    # if element at high is greater than element at mid means 2nd half is sorted starting from mid element till last
        if nums[high] >= nums[mid]:
            if nums[mid] <= target <= nums[high]:
                low = mid+1
            else:
                high = mid-1
    # if element at mid is greater than element at low means 1st half is sorted starting from low element till mid
        if nums[low] <= nums[mid]:
            if nums[low] <= target <= nums[mid]:
                high = mid-1
            else:
                low = mid+1
    return -1

print(findrotate(nums = [4,5,6,7,0,1,2], target = 0))