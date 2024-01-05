# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high*2

        return self.binarySearch(low,high,reader,target)

    def binarySearch(self,low,high,reader,target):
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid)== target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1