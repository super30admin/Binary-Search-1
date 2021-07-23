"""
Time Complexity:    O(log(n))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the target,
but adding a catch that i am finding the sorted side first.
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if target == nums[mid]:
                return mid
            if nums[low] <= nums[mid]:  # sorted
                if target < nums[mid] and target >= nums[low]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
