# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # upper bound is given in the problem as 10000.
        # Then it boils down to regualr binary search
        l, r = 0, 10000
        while l <= r:
            mid = (l+r)//2
            val = reader.get(mid)
            if val == target: return mid
            elif val < target: l = mid+1
            else: r = mid-1 
        return -1
        