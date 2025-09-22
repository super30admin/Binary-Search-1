# Problem 2: Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Time Complexity: O(log n) where n is the number of elements in the array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We perform binary search while determining which side (left or right) is sorted.
# If the target lies within the sorted side, we adjust our search to that side.
# Otherwise, we search in the other side.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return None

        low, high = 0, len(nums)-1

        while low <= high:
            mid = low + (high-low)//2

            if nums[mid] == target:
                return nums.index(target)

            # left sorted
            if nums[low] <= nums[mid]: 
                if target >= nums[low] and target < nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            # right sorted
            if nums[mid] <= nums[high]:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1 