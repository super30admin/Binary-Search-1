from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        row = 0
        for i in range(rows):
            if matrix[i][0] > target:
                row = i - 1
                break
        else:
            row = rows - 1
            
        for j in range(cols):
            if matrix[row][j] == target:
                return True
        return False