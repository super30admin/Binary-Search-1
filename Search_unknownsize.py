# Search in a sorted array of unknown size
# Time Complexity: O(log n)
import sys
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
        # performs binary search
        def binarySearch(reader, target, l, h):
            while l <= h:
                
                m = l + (h-l) // 2

                if reader.get(m) == target:
                    return m
                elif reader.get(m) < target:
                    l = m + 1
                else:
                    h = m - 1
            return -1
        
        h = 1
        # check if the elem is not equal to infinity
        # elem at h pos is less than equal to target
        while reader.get(h) is not sys.maxsize and reader.get(h) <= target:
            # jump the h ptr by 2
            h *= 2
        # perform binary search on it
        return binarySearch(reader, target, 0, h)
    
    