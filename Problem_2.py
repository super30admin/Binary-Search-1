# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Approach: Since the given array is in sorted order, we can use Binary search

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        
        while low<=high:
            mid = low+(high-low)//2
            if reader.get(mid)==target:
                return mid
            elif target<=reader.get(high):
                if target<reader.get(mid):
                    high = mid-1
                else:
                    low = mid+1
            else:
                high = 2*high
        
        return -1
              
# Time Complexity: O(logN)
# Space Complexity: O(1)