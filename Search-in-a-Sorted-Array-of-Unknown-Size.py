# Time Complexity O(1) for the search
# Accepted in leetcode

class Solution(object):
    def search(self, reader, target):
        l = 0
        h = 1
        while reader.get(h) < target:
            if reader.get(h) < target:
                l = h
                h = 2 * h
        return self.BinarySearch(reader, h, l, target)

    def BinarySearch(self, reader, high, low, target):
        while low <= high:
            mid = low + (high - low)/2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
