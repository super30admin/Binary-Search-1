# Did this code successfully run on Leetcode : YES

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
        l, r = 0, 1
        while reader.get(r) < target:
            l = r
            r = r * 2
            
        while l <= r:
            m = int((l+r)/2)
            if reader.get(m) == target:
                return m
            elif reader.get(m) < target:
                l = m + 1
            else:
                r = m - 1
        return -1