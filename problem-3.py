# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = target - reader.get(0)
        if reader.get(left) == target: return left
        if reader.get(right) == target: return right
        while(left <= right):
            mid = (left+right) // 2
            if reader.get(mid) == target: return mid
            elif reader.get(mid) < target: left = mid + 1
            else: right = mid - 1
        return -1
        
        