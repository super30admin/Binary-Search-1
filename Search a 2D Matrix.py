"""
Time complexity : O(log c) + O(r)
    r -> row
    c -> column
    
Space Complexity : O(1)
    
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        row = self.findRow(matrix, target)
        column = self.binarySearch(matrix, row, target)
        return True if row is not None and column is not None else False
    
    def findRow(self, matrix, target):

        for i in range(len(matrix)) :
            if matrix[i][0] <= target <= matrix[i][-1]:
                return i
        
        return None
    
    def binarySearch(self, matrix, row, target):
        if row is None:
            return None
        l = 0
        r = len(matrix[row]) -1
        
        while l <= r :
            mid = l + ((r-l) >> 1)
            
            if matrix[row][mid] == target :
                return mid
            
            elif matrix[row][mid] > target:
                r = mid - 1
            
            else :
                l = mid + 1
        
        return None
        
