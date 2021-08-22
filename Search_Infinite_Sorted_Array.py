# time complexity: O(logn)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

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
        while ArrayReader.get(reader, right) < target:
            left = right
            right = right*2
        
        while left <= right:
            mid = (left + right)//2
            if target == ArrayReader.get(reader, mid):
                return mid
            elif target <  ArrayReader.get(reader, mid):
                right = mid - 1
            elif target >  ArrayReader.get(reader, mid):
                left = mid + 1
        
        return -1
                