# Time Complexity :  O(log(index of target))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : -
# Any problem you faced while coding this : I do not have a LC Premium account

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
        
        
        end = 1
        
        while reader.get(end) < target:            
            end *= 2
            
            
        start = 0
        
        while start + 1 < end:
            
            mid = start + (end - start) // 2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                start = mid
            else:
                end = mid
                
        
        if reader.get(start) == target:
            return start
        
        if reader.get(end) == target:
            return end
        
        return -1