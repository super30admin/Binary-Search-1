class Solution(object):
    def searchMatrix(self, matrix, target):
        if (matrix is None or len(matrix) == 0):
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n) - 1
        
        while low<=high:
            mid = low + (high - low)//2
            col = int(mid%n)
            row = int(mid/n)
            
            if (matrix[row][col] == target):
                return True
            elif (matrix[row][col]> target):
                high = mid - 1
            else:
                low = mid + 1
        
        return False
    
    # TC: O(log mn)
    # SC: O(1)
