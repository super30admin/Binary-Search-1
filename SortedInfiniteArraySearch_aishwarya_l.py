from typing import List

"""
The time complexity is of binary search : O(n)
Space complexity is O(1)
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # base case:
        if len(nums) == 0:
            return -1

        low = 0
        high = 1

        while low <= high:
            mid = (low + high) // 2  # in Java,C++ handle integer over flow iwth low+ (high-low)/2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = high
                high = 2*high
            else:
                high = mid - 1

        return -1
