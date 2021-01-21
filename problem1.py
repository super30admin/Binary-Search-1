// Time Complexity : O(log nm)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n=len(matrix)
        m=len(matrix[0])

        low=0
        high=n*m-1
        
        while low<=high:
            mid=low+(high-low)//2
            i= mid//m 
            j= mid%m
            if target==matrix[i][j]:
                return True
            elif target<matrix[i][j]:
                high=mid-1
            else:
                low=mid+1
        return False
