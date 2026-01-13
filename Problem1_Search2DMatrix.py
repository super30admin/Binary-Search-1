# Time Complexity : O(log(m*n)) where m is rows and n is columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Treat the 2D matrix as a 1D sorted array and perform binary search.
# Calculate row and column indices from the 1D index using division and modulo operations.
# Compare target with middle element and adjust search boundaries accordingly.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = m * n - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            row = mid // n
            col = mid % n
            mid_value = matrix[row][col]
            
            if mid_value == target:
                return True
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False

