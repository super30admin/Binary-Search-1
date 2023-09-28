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
        max_val = (2 ** 31) - 1
        if reader.get(0) == max_val: return -1

        def findBound(lo, hi):
            if reader.get(hi) != max_val:
                if (reader.get(hi) >= target):
                    lo, hi = (lo, hi)
                else:
                    lo, hi = findBound(hi + 1, ((hi + 1) * 2))
            return (lo, hi)

        values = findBound(0, 1)
        lo = values[0]
        hi = values[1]
        while lo <= hi:
            mid = (lo + hi) // 2
            if reader.get(mid) == max_val:
                hi = mid - 1
            else:
                if target == reader.get(mid): return mid
                if target < reader.get(mid):
                    hi = mid - 1
                else:
                    lo = mid + 1
        return -1