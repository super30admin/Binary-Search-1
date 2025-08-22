# Time Complexity : O(logn)
# Space Complexity : O(1)  as not using any extra space doing it in place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Silly mistake with the greater than condition


# Your code here along with comments explaining your approach:
# I am using binary search to find the target in the array. I find the mid by taking low as 0 and high as the last index of the array.
# Then I compare the mid element with the target , I first check if the left half is sorted then I check if the target lies within the bounds of the left half.
# If it does, I search the left half, otherwise I search the right half. If found I return that element or else I return -1.

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high - low) //2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[mid] > target and nums[low] <= target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
                
        return -1
