# Time Complexity : O(log n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

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

        left = 0
        right = 1
        
        #Do binary serach to acquire the desired index
        while (target > reader.get(right)):
            left = right
            right = right * 2
        #This is to prevent integer overflow
        while  left <=right:
            mid = left + (right-left) // 2
            
            if(reader.get(mid) == target):
                return mid
            elif target < reader.get(mid):
                right = mid -1
            else:
                left = mid + 1
        return -1