# Time Complexity : O(2logn) but ignoring constants it is O(logn)
# Space Complexity : O(1)  as not using any extra space doing it in place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
#I am using binary search to find the target in the ArrayReader. I start with a low pointer at 0 and a high pointer at 2.
# I then double the high pointer until the value at the high pointer is greater than the target. This helps me find the search space.
# After finding the search space, I perform a standard binary search within that space.

from typing import List
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 2
        while reader.get(high) <= target:
            low = 0
            high *= 2
        while low <= high:
            mid = low + (high - low) //2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

        