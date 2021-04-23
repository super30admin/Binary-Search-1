#Search in a Sorted Array of Unknown Size

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:
'''Time complexity : O(log n +log searchspace) n -> number of steps. linear complexity
Space Complexity: O(1)
Did this code successfully run on Leetcode :    Yes
Any problem you faced while coding this: No '''
#approach - set low = 0  and high as 1. then perform binary search. then increase the search space
#by 2. high = 2*high and low = high again do binary search in the newly defined search space.

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 1
        if reader.get(0) == target:
            return 0
        while reader.get(high) < target:
            low = high
            high = 2*high
         #binary search
        while low <= high:
            mid = low + (high - low)//2
            x = reader.get(mid)
            
            if x == target:
                return mid
            if x < target:
                low = mid + 1
            else:
                high = mid - 1
        
        # there is no target element
        return -1
