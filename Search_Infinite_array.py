# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        first = 0
        last = 2
        while reader.get(last)<target:
            last *= 2
        while first <= last:
            mid = first + (last-first)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                last = mid - 1
            else:
                first = mid + 1
        
        return -1