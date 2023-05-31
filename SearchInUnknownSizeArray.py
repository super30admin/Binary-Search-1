# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        high = 10000
        low = 0

        while low <= high:
            mid = (low + high) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            
            if val == 2**31 - 1 or val > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1