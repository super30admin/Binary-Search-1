# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """    
        low, high = 0, 1
        
        ### O(logN)
        while (target>reader.get(high)):
            low = high
            high = high * 2
        
        if target == reader.get(high):
            return high
        
        ### O(logN)
        while (low <= high):
            mid = low + (high-low)//2
            
            # Happy Case
            if reader.get(mid) == target:
                return mid
            
            # Reduce search space to left half
            if reader.get(mid) > target:
                high = mid-1
            
            # Reduce search space to right half
            else:
                low = mid + 1
        
        return -1
    
### Complexity Analysis ###

# Time: O(logN) + O(logN) = O(logN)
# Space: O(1)