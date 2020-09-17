# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : It took me 40 mins to get the approach. Previously was doing in O(n)


# // Your code here along with comments explaining your approach: 
# 1. Find the end
# 2. Perform binary search

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
        if target == reader.get(0):
            return 0
        start, end = 0, 1
        while target > reader.get(end): # Extend right until target is less then value in right
            start = end
            end *= 2
            
        while start <= end: # Perform binary search
            mid = start + ( end - start ) // 2
            if target == reader.get(mid):
                return mid
            if target < reader.get(mid):
                end = mid - 1
            else:
                start = mid + 1
        
        return -1