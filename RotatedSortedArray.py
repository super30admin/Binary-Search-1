# Time Complexity: O(log(n)), n is the number of elements in the array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach in three sentences only
"""
# Uses binary search to find a target in a rotated sorted array.
# Determines which half of the array is sorted at each step.
# Adjusts the search range based on where the target may lie.
"""

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) -1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: # left half is sorted
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else: # right half is sorted
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1


    