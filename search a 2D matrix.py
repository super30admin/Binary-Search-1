#LC: yes, 74
#problems: NA
#TC: O(logmn), n is no of cols,m is no of rows
#SC: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        #looping on my imaginary 1D array:
        n = len(matrix[0])
        m = len(matrix)
        
        low = 0
        high = m*n -1
        
        while low <= high:
            
            mid = low + (high - low)//2
            
            row = mid //n 
            col = mid % n
            
            if matrix[row][col] ==  target: 
                return True
                #return (row, col)
            
            elif matrix[row][col] < target:
                low = mid + 1
                
            else: 
                high = mid - 1
        return False
    
#TC: O(m+logn),  n is no of cols,m is no of rows
#SC: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix[0])
        m = len(matrix)
        
        i = 0
        rIdx = 0
        #find row
        while i < m:
            if matrix[i][0] <= target <= matrix[i][n-1]:
                rIdx = i
                break
            i += 1
        
        #convert to imaginary 1D array indices
        # low = rIdx*n
        # high = low + (n - 1)
        
        low = 0
        high = n-1
        while low <= high:
            
            mid = low + (high - low)//2
            
            #convert to 2D indices
            # row = mid // n
            # col = mid % n
            value = matrix[rIdx][mid]
            
            if target == value:
                return True
            
            elif target < value:
                high = mid - 1
                
            else: 
                low = mid + 1
        return False
                
#TC: O(logm+logn),  n is no of cols,m is no of rows
#SC: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix[0])
        m = len(matrix)
        
        low = 0
        high = m - 1
        rIdx = 0
        
        #find row
        while low <= high:
            
            mid = low + (high - low)//2
            if matrix[mid][0] <= target and matrix[mid][n-1] >= target:
                rIdx = mid
                break
            
            elif target < matrix[mid][0]:
                high = mid - 1
                
            else: 
                low = mid + 1
        
        low = 0
        high = n - 1
        
        while low <= high:
            
            mid = low + (high - low)//2
            
            if matrix[rIdx][mid] == target:
                return True
            
            elif matrix[rIdx][mid] > target:
                high = mid - 1
                
            else: 
                low = mid + 1
        return False
            
            