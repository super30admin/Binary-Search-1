# Leetcode 74: Search in a 2d matrix
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        if rows ==0:
            return False
        
        end = rows*cols -1 
        start = 0
        
        while(start<=end):
            mid = (start + end)//2
            
            if(matrix[mid//cols][mid%cols] == target):
                return True
            
            if (target < matrix[mid//cols][mid%cols]):
                
                end = mid-1
            else:
                start = mid+1
        
        return False