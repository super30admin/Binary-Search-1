# Time Complexity - O(log(N))

# Space Complexity - O(1)

# Approach
# I fisrst try to set my high pointer such that the target lies between high and low.
# Then I run a normal binary search

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySearch(self, reader, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0) == target:
            return 0

        low = 0
        high = 1
        while (target > reader.get(high)):
            low = high
            high = 2 * high

        return self.binarySearch(reader, low, high, target)
