// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        
        i = 0
        j = 1
        
        while (target > reader.get(j)):
            i = j
            j <<= 1  #bitwise shift-left 
        
        while (i<=j):
            mid = i + ((j-i) >> 1 )
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                j = mid -1
            else:
                i = mid + 1
        return -1
            
