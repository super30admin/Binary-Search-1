# Time Complexity : O(logn)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took time to figure out implementation

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
        left,right = 0,1
        #if target at 0th index
        if reader.get(0) == target:
            return 0
        #find left and right boundary for binary search
        while reader.get(right) < target:
            left = right
            right <<=1
        #do binary search
        while left <= right:
            mid = (left+right)//2
            if reader.get(mid) == target:
                return mid
            if target < reader.get(mid):
                right = mid-1
            else:
                left = mid+1
        return -1
