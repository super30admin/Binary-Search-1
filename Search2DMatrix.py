# Time Complexity : O(log m + log n) or O(log(mn) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Finding Mid for Row and Column

class Solution:
    
    def findRow(self,matrix,rows,target):
        
        if not matrix or target is None:
            return False

        r1 = 0
        r2 = rows - 1
        
        while  r1 <= r2:
            rmid = (r1+r2) // 2
            if matrix[rmid][0] <= target <= matrix[rmid][-1]:
                return rmid
            elif target < matrix[rmid][0]:
                r2 = rmid-1
            elif target > matrix[rmid][-1]:
                r1=rmid+1
        return None
                  
    def searchMatrix(self, matrix, target):
        
        if not matrix or target is None:
            return False
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        if rows == 1 and cols == 1:
            if target != matrix[rows-1][cols-1]:
                return False
        
        low = 0
        high = cols - 1
        row = self.findRow(matrix,rows,target)
        
        if row==None:
            return False
        
        while low <= high:
            mid = (low + high) // 2
            if target == matrix[row][mid]:
                return True
            elif target < matrix[row][mid]:
                high = mid - 1
            else:
                low = mid + 1     
        return False


# Brute Force
 
class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        i = 0
        while i < m:
            low = 0
            high = n-1
            while low <= high:
                mid = (low + high) // 2
                if target == matrix[i][mid]:
                    return True
                elif target < matrix[i][mid]:
                    high = mid-1
                else:
                    low = mid + 1
            i += 1
        return False

# Using number = matrix[mid // cols][mid % cols]

class Solution:
    def searchMatrix(self, matrix, target):
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        low = 0
        high = rows*cols - 1
        
        while low <= high:
            
            mid = (low + high) // 2
            number = matrix[mid // cols][mid % cols]
            
            if target == number:
                return True
            elif target < number:
                high = mid - 1
            else:
                low = mid + 1
        
        
        
                
        
            
        