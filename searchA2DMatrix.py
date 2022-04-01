#  Time Complexity : O(1)
#  Space Complexity : O(log(m*n))
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        
        low = 0
        high = m*n-1
        
        
        while low <= high:
            
            mid = low+(high-low)//2
            
            r = mid//n
            c = mid%n
            
            if matrix[r][c] == target:
                return True
            
            if matrix[r][c] < target:
                low = mid+1
            else:
                high = mid-1
                
        return False