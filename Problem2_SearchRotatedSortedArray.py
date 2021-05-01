# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Solution:
"""
1. Using binary search approach, find the mid element and check if any of the sides is sorted.
2. If target lies within the range of the sorted side, perform binary search in that range.
3. Else perform the search in the unsorted side. Repeat the steps until the element is found.
"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == nums[mid]:
                return mid

            # Left side is sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            # Right side is sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1