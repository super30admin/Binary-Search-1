import math


""""
Time complexity - O(log(m*n))
"""
class Solution:
   
        
    def binarySearch(self, start, end, matrix, rows, cols, target):
        # All the array elements will be in sorted order
        # when traversed row wise.
        mid = math.floor((start + end) / 2)
        row = math.floor(mid / cols)
        col = mid % cols
        if matrix[row][col] == target:
            return True       
        if start < end:
            if matrix[row][col] > target:
                return self.binarySearch(start, mid,matrix,rows,cols,target)
            elif matrix[row][col] < target:
                return self.binarySearch(mid+1, end,matrix,rows,cols,target)
            return False
        return False
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        start = 0
        rows = len(matrix)
        cols = len(matrix[0])
        end = rows*cols -1
        return self.binarySearch(start, end, matrix, rows,cols, target)
        
            
        
        