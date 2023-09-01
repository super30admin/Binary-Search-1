# Time Complexity = O(logn)
# Space Complexity = O(1)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1
        while target > reader.get(high):
            low = high
            high = 2 * high

        while low <= high:
            mid = low + (high - low) // 2

            if target == reader.get(mid):
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1
        
        return -1