# leet code passed
# leet code 74
# 0(logN)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        import math
        if len(matrix) == 0:
            return False
       
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        while low <= high:
            
            mid = (low + high)//2
            row = mid//n
            col = mid%n
            if target == matrix[row][col]:
                return True
            else:
                if target > matrix[row][col]:
                    low = mid+1
                else:  
                    high = mid-1
        return False
        