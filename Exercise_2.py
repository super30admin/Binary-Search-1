# https://leetcode.com/problems/search-in-rotated-sorted-array/

# Time complexity: O(log n)
# Space complexity: O(1)

# Explanation: Perform binary search but when shifting low or high, figure out which part of the sorted array you are currently in, and then shift acc.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid
            
            # left sorted
            if nums[low] <= nums[mid]: 
                if nums[low] <= target < nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            # right sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            
        return -1
