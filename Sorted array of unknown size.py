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
        if reader.get(0) == target:
            return 0

        l, r = 0, 1
        while reader.get(r) < target:
            l = r
            r <<= 1

        while l <= r:
            mid = l + ((r - l) // 2)
            temp = reader.get(mid)
            if temp == target:
                return mid

            if temp > target:
                r = mid - 1
            else:
                l = mid + 1

        return -1