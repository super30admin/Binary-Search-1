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
        Constraints is that the array is from 1 to 10000..
        To solve this can't we just do regular binary search where, 
        left = 0 and right is just 10,000? Well it passed. What if size of data is not known though?
        """     
        left = 0
        right = 10000
        
        while left <= right:
            mid = left+ (right-left) // 2
            
            #found
            if reader.get(mid) == target:
                return mid
            #if target is somewhere on the right 
            elif reader.get(mid) < target:
                left = mid + 1
            #target is somewhere on the left
            else:
                right = mid - 1
        
        return -1 