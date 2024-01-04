## Problem3
# Search in Infinite sorted array: 
# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

class Solution:
    """
    @reader: reader.get(k) returns the element of the array at index k (0-indexed).
    @return: return target index
    """
    def search(self, reader: ArrayReader, target: int) -> int:
        # write your code here
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2
        while low <= high:
            mid = low + ((high-low)//2)
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
# time complexity is O(log2m + log2n)
#log2m is for finding the low and high range
#log2n is for binary search between low and high
#space complexity O(1)