## Problem2 
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

#O(log2n) - time complexity
#O(1) - space complexity
#1. check whether left or right part of mid is sorted
#2. update the low or high values depending on the target