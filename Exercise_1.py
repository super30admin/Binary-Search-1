# 33. Search in Rotated Sorted Array

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #33
# Any problem you faced while coding this : No

# Approach:
# Using Binary search in rotated sorted array
# Taking mid, atleat one side of the array is sorted. Check if target is in the sorted list, if not search on other side.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            # left array is sorted
            if nums[mid] >= nums[low]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            # right side is sorted
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid -1
        return -1 