class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low, high = 0, m*n - 1
        while(low <= high):
            middle = low + (high - low) // 2
            r = middle // n
            c = middle % m
            if(matrix[r][c] == target):
                return True    
            elif (target < matrix[r][c]):
                high = middle - 1
            else:
                low = middle + 1
                
        return False