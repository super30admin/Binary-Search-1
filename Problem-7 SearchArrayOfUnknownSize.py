# 702. Search in a Sorted Array of Unknown Size

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
        l = 0
        h = 1

        # Find the range of index where the target maybe present
        while target > reader.get(h):
            l = h
            h = h*2
        
        # In the range using binary search, try to find the target
        while l <= h:
            mid = l + (h-l)//2

            if target == reader.get(mid):
                return mid
            elif target > reader.get(mid):
                l = mid + 1
            else:
                h = mid - 1
        
        return -1