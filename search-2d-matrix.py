"""
This implementation uses binary search to find the target in a 2D matrix.
The matrix is treated as a flattened 1D array, and the binary search is applied to this array.
The row and column indices are calculated from the 1D index to simulate the 2D matrix structure.
"""

# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
            
        rows, cols = len(matrix), len(matrix[0])
        left, right = 0, rows * cols - 1
        
        while left <= right:
            mid = (left + right) // 2
            # Convert 1D index to 2D coordinates
            row = mid // cols
            col = mid % cols
            current = matrix[row][col]
            
            if current == target:
                return True
            elif current < target:
                left = mid + 1
            else:
                right = mid - 1
                
        return False
        