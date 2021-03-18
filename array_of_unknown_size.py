# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity: O(log(n) + log(k)) where k is the number of elements to be used for searching
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# Difficulties: Getting the high index

class Solution:
    def binarySearch(self, reader, target, l, h):
        while l <= h:
            mid = l + (h - l) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                h = mid - 1
        return -1
    
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l = 0
        h = 1
        while (reader.get(h) < target):
            l = h
            h = 2*h
        return self.binarySearch(reader, target, l , h)
        