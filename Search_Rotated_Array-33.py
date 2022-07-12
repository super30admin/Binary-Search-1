## Problem2  - Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Time Complexity: O(logn) - Applying binary search
# Space Complexity: O(1) - No extra space needed
# Leetcode Problem solved successfully?: Yes
# Code:
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        
        if n == 0: # If length is 0
            return -1

        low = 0
        high = n -1 
        
        while(low<=high):
            mid = low + (high - low) // 2   # To avoid Integer Overflow
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:  # Check if left sub array is sorted
                if target >= nums[low] and target < nums[mid]:  # Check if target belongs to this subarray
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]: # Check if target belongs to this subarray
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1

#Approach: In a rotated sorted array, after calculating the mid, one of the sub array will be sorted while the other part would be unsorted. 
#          First, we calculate the mid and check if array[low] < array[mid], if yes then the left part is sorted. We then check if target belongs to left part, if yes we do high = mid - 1 else low = mid + 1
#          Same will be the approach for the right side of the array. 
