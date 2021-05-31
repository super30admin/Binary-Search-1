# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySeach(self, reader, low, high, target):
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        
            
    def search(self, reader, target):
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2 * high
        return self.binarySeach(reader, low, high, target)
        


# Time Complexity: O(log(n))
# Space Complexity: O(1)