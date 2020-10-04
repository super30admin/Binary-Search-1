# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    # Time Complexity - O(logN)
    # Space Complexity - O(1)
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        while reader.get(high) != 2147483647:
            high = high * 2
        return self.binarySearch(reader, low, high, target)
        
    def binarySearch(self, reader, low, high, target):
        while low <= high:
            mid = low + (high-low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
                
        