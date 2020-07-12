# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
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
        l = 0
        h = 0
        
        # Find the subarray that contains the target
        while(reader.get(h) < target):
            l = h
            h = h*2 + 1
            
        # Apply binary search in the sub array
        while l < h:
            m = l + (h-l)//2
            
            if reader.get(m) < target:
                l = m + 1
            else:
                h = m
                
        if reader.get(l) == target:
            return l
        else:
            return -1