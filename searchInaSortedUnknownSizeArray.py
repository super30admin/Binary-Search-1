# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader(object):
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
        hi = 10000
        max_val = (2 ** 31) - 1
        lo = 0

        while lo <= hi:
            mid = lo + ((hi - lo // 2))
            if reader.get(mid) == max_val:
                hi = mid - 1
            else:
                if target == reader.get(mid): return mid
                if target < reader.get(mid):
                    hi = mid - 1
                else:
                    lo = mid + 1
        return -1