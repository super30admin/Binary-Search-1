# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation(

"""
TC: O(logn)
SC: O(1)
"""

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
        ar = reader
        maxLen = int(10 ** 4)

        start, end = 0, maxLen
        
        while start <= end:
            mid = start + (end - start) // 2
            if ar.get(mid) == 2**31 - 1:
                end = mid - 1
                continue
            if ar.get(start) == 2**31 - 1:
                return -1
            if ar.get(mid) == target:
                return mid
            if ar.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1
        
        return -1
        
        