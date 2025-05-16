# """
# Search in a sorted array of unknown size
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def findHighIndex(self, reader, target):
        high = 1
        if reader.get(0) == target:
            return 0
        while reader.get(high) < target:
            high *= 2
        return high
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = self.findHighIndex(reader, target)
        while low<=high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

