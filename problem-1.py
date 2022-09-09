# Search a 2D Matrix

# Time Complexity : O(log m * log n) where m = no.of rows, n = no. of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        
        top, bot = 0, ROWS - 1
        
        while top <= bot:
            midRow = (top + bot) // 2
            if target > matrix[midRow][-1]:
                top = midRow + 1
            elif target < matrix[midRow][0]:
                bot = midRow - 1
            else:
                break
                
        if not (top <= bot):
            return False
    
        row = (top+bot) // 2
        l, r = 0, COLS - 1
        
        while l<=r:
            mid = (l + r) // 2
            
            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid+ 1
            else:
                return True
        return False
        

