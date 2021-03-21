# Time Complexity : O(log n) where n is the size of input array
# Space Complexity : O(n) where n = size of input array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Your code here along with comments explaining your approach
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        low = 0
        high = low + 1

        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid

            if target > reader.get(high):
                low = high
                high = 2 * low
            else:
                if reader.get(mid) < target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
