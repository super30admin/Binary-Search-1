# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

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
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = int(low + (high - low) / 2)

            if reader.get(mid) == target:
                return mid

            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
