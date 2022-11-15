"""
    Problem Statement: Write an efficient algorithm that searches for a value target in a rotated sorted array.

    Time complexity: log(n)
    
    Space complexity: O(1).

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
"""

from typing import List
import math

class Reader:
    def __init__(self, target):
        self.target = target
        self.nums = list(range(target-10, target+3))

    def get(self, number):
        if number in self.nums:
            return self.nums.index(number)
        else:
            return math.inf

class Solution:
    def search(self, reader, target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2
        print(low, high)
        return self._binary_search(reader, target, low, high)
    
    def _binary_search(self, reader, target, low, high):
        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1
        return -1 


if __name__ == "__main__":
    s = Solution()
    target = 20
    reader = Reader(target)
    ret = s.search(reader, target)
    assert ret == 11