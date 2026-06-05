## Problem1 
# Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])

        low = 0
        high = (rows * cols) - 1

        # treat the matrix as 1D array
        while low <= high:
            mid = low + (high - low) // 2
            # convert 1D mid to row and column index of the matrix
            # they are functions of the number of columns
            row = mid // cols
            col = mid % cols

            valueAtMid = matrix[row][col]
            if valueAtMid == target:
                return True
            
            if target < valueAtMid:
                high = mid - 1
            else:
                low = mid + 1
        
        return False