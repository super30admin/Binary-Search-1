'''
Time complexity: O(log n) + O(log n ) = O(log n)
Space complexity: O(1)
'''
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
            high *= 2

        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val > target or val == 2**31 - 1:
                high = mid - 1
            else: 
                low = mid + 1
        return -1