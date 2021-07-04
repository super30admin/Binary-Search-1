"""
Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode?: Yes

Problem:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
"""

# this solution is a tweaked version of the traditional binary search
def search(nums, target):
    # edge case
    if (not nums or len(nums)==0):
        return -1
    
    low = 0
    high = len(nums) - 1
    
    while low <= high:
        mid = low + (high-low) // 2
        if nums[mid] == target:         # return mid idx if target is found at nums[mid]
            return mid
        elif nums[low] <= nums[mid]:    # this case means that surely the left side of the array is sorted
            if target >= nums[low] and target <= nums[mid]:     # moves the high/low pointers to appropriate loc.
                high = mid - 1
            else:
                low = mid + 1
        else:                           # nums[low] > nums[mid] - basically means right side of the array is sorted
            if target <= nums[high] and target >= nums[mid]:    # moves the high/low pointers to appropriate loc.
                low = mid + 1
            else:
                high = mid - 1
                
    return -1   # if target is not found

# Testing
print(search([4,5,6,7,0,1,2], 0))
print(search([4,5,6,7,0,1,2], 8))
print(search([3,1], 1))