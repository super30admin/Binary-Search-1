# time complexity : O(log n)
# space complexity: O(1)

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
        if reader.get(0)== target:
            return 0
        lo = 0
        hi = 1
        while(reader.get(hi)< target ):
            lo = hi
            hi = hi * 2
        while(lo<=hi):
            mid = lo + (hi-lo)//2
            num = reader.get(mid)
            if num == target:
                return mid
            elif num < target:
                lo = mid+1
            else:
                hi = mid -1
        return -1
                