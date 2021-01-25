# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        h = 1
        while target > reader.get(h):
            h = h * 2
        l = 0
        while l <= h:
            mid = l + (h - l) // 2
            if target == reader.get(mid):
                return mid
            elif target < reader.get(mid):
                h = mid - 1
            else:
                l = mid + 1
        return -1
