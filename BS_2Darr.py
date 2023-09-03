# // Time Complexity :O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# Your code here along with comments explaining your approach in three sentences only
# Made this as a single array without storing it in an array made calculations to find the indices of the element and performed binary search

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        size=(len(matrix[0])*len(matrix))
        low=0
        high=size-1

        while(low <= high  ):
            #print("low and high",low,high)
            mid=int(low+(high-low)/2)
            val=matrix[int(mid/len(matrix[0]))][int(mid%len(matrix[0]))]
            #print("val",val)
            if(val == target):
                return True
            elif(target > val ):
                low=mid+1
            elif(target< val):
                high= mid-1
        
        return False