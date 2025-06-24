# Time Complexity: O(log n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: No
# Any problem you faced while coding this: No


# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 1
        
        while reader.get(high) <= target:
            # start with small nos, keep increasing high by factor of 2 for binary search until high is greater or equal to target
            low = high
            high *= 2
            
        return self.searchRange(reader, target, low, high)
            
        
        
    
    def searchRange(self, reader, target, low, high)-> int:
        
        while low<=high:
            
            mid = low+(high-low) //2 
            
            if reader.get(mid) == target:
                return mid
            
            # search in left window if mid value greater than target else right window
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return -1
                
            