// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        
        low=0
        high=m*n-1
        
        while(low<=high):
            mid=int(low+(high-low)/2)
            row = int(mid/n)
            col = mid % n
            
            if matrix[row][col]==target:
                return True
            elif matrix[row][col] > target:
                high = mid-1
            else:
                low=mid+1
        return False
        