# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. Since the input list is an infinite sorted steam, we need to define the end index to apply binary search. Any index which holds a value greater or equal to the target can be taken as end index
# 2. The end index is initialized with value 1. The value is doubled at each iteration until a desired value has been reached





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
        low, high = 0,1
        
        # Look for the end index
        while reader.get(high) < target:
            low = high + 1
            high *= 2
            
        while low<= high:
            mid = (low+high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid+1
            else:
                high = mid-1
        return -1