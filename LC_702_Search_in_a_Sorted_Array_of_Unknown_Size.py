"""
Search in a Sorted Array of Unknown Size (Leetcode 702)

Time Complexity : O(log(n)) - where n is the (unknown) index of target, since exponential search finds bounds in O(log n) 
and binary search within them also takes O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 702. Search in a Sorted Array of Unknown Size) : Yes
Any problem you faced while coding this : None

Approach:
Since the array size is unknown, we first find a valid search range by doubling the high pointer (exponential/galloping search) until reader.get(high) is no longer less than the target.
Once we have bounds where the target must lie, we run standard binary search between low and high to locate the exact index.
The ArrayReader.get() method returns a large sentinel value for out-of-bound indices, which naturally stops the doubling step from running forever.
"""
from __future__ import annotations
from typing import List

class ArrayReader:
    """Mock of Leetcode's ArrayReader interface for local testing."""
    def __init__(self, nums: List[int]):
        self.nums = nums

    def get(self, index: int) -> int:
        if index >= len(self.nums):
            return 2**31 - 1
        return self.nums[index]


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + (high - low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


def run_tests():
    assert Solution().search(ArrayReader([-1,0,3,5,9,12]), 9) == 4
    assert Solution().search(ArrayReader([-1,0,3,5,9,12]), 2) == -1
    assert Solution().search(ArrayReader([5]), 5) == 0
    assert Solution().search(ArrayReader([5]), -5) == -1
    assert Solution().search(ArrayReader([1,3,5,7,9,11,13,15,17,19]), 19) == 9
    print("All Search in Unknown Sized Array test cases passed!")


if __name__ == "__main__":
    run_tests()