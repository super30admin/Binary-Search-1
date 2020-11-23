# Time complexity: O(log(n))
# Space Complexity: O(1) 
# Approach: Binary search; First we decide high and low until we find desired sublist where our target lies between low and high. 
# After that, it normal binary search to search for target between high and low.


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
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
        while target >= reader.get(high):
            low = high
            high = 2 * high
        
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1