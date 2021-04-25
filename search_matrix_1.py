""" Time Complexity : O(logn)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No """


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m,n = len(matrix),len(matrix[0])
        low,high = 0,m*n - 1
        
        while low <= high:
            
            mid = int(low + (high-low)/2)
            
            r = int(mid / n)
            c = int(mid % n)
            
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return False