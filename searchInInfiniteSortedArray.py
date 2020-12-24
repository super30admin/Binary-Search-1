# Time Complexity : O(lgN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No..but I did have some doubts
# regarding the question itself. It seems that I could just do regular binary search
# but this was only because I was given the size of the data.


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
        """
        calculated the highest val I can go to (Just enough where high > target)
        """
        left = 0
        right = 1
        while reader.get(right) < target:
            left = right
            right = right*2
            
        return self.binarySearch(left, right, target, reader)
    
    def binarySearch(self, left, right, target, reader):
        
        while left <= right:
            mid = left + (right-left) // 2
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                right = mid - 1
            else:
                left = mid + 1
                
        return -1